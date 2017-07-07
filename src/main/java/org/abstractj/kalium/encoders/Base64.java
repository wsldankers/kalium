/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.abstractj.kalium.encoders;

import static java.util.Base64.getEncoder;
import static java.util.Base64.getDecoder;

/**
 * Converts base64 Strings.
 * <p/>
 * This class is thread-safe.
 */
public class Base64 implements Encoder {
    private java.util.Base64.Encoder javaBase64Encoder;
    private java.util.Base64.Decoder javaBase64Decoder;

    public Base64() {
        javaBase64Encoder = getEncoder();
        javaBase64Decoder = getDecoder();
    }

    /**
     * Converts an array of bytes into a String representing the base64 encoded values of each byte in order. The returned
     * String will be approximately 33% larger than the length of the passed array, as it takes 4 characters to represent 3 bytes.
     * The result string is padded to a multiple of 4 characters.
     *
     * @param data a byte[] to convert to base64 characters
     * @return A String containing base64 characters
     * @since 0.6.1
     */
    @Override
    public byte[] decode(final String value) {
        if (value == null)
            return null;
        return javaBase64Decoder.decode(value);
    }

    /**
     * Converts an array of bytes into a String representing the base64 encoded values of each byte in order. The returned
     * String will be 25% shorter than the passed array, as it takes 4 characters to represent 3 bytes.
     * Padding is optional.
     *
     * @param data a byte[] to convert to base64 characters
     * @return A String containing base64 characters
     * @since 0.6.1
     */
    @Override
    public String encode(final byte[] data) {
        if (data == null)
            return null;
        return javaBase64Encoder.encodeToString(data);
    }
}
