// Copyright 2015 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package io.github.importre.eddystone

internal object Utils {
    private val HEX = "0123456789ABCDEF".toCharArray()

    fun toHexString(bytes: ByteArray): String {
        if (bytes.size == 0) {
            return ""
        }
        val chars = CharArray(bytes.size * 2)
        for (i in bytes.indices) {
            val c = bytes[i].toInt() and 255
            chars[i * 2] = HEX[c.ushr(4)]
            chars[i * 2 + 1] = HEX[c and 15]
        }
        return String(chars).toLowerCase()
    }

    fun isZeroed(bytes: ByteArray): Boolean {
        for (b in bytes) {
            if (!b.equals(0)) {
                return false
            }
        }
        return true
    }

}
