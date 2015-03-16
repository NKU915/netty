/*
 * Copyright 2015 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class DatagramDnsQuery extends DefaultDnsQuery
        implements AddressedEnvelope<DatagramDnsQuery, InetSocketAddress> {

    private final InetSocketAddress sender;
    private final InetSocketAddress recipient;

    public DatagramDnsQuery(
            InetSocketAddress sender, InetSocketAddress recipient, int id) {
        this(sender, recipient, id, DnsOpCode.QUERY);
    }

    public DatagramDnsQuery(
            InetSocketAddress sender, InetSocketAddress recipient, int id, DnsOpCode opCode) {
        super(id, opCode);
        this.sender = sender;
        this.recipient = recipient;
    }

    @Override
    public DatagramDnsQuery content() {
        return this;
    }

    @Override
    public InetSocketAddress sender() {
        return sender;
    }

    @Override
    public InetSocketAddress recipient() {
        return recipient;
    }

    @Override
    public DatagramDnsQuery setId(int id) {
        return (DatagramDnsQuery) super.setId(id);
    }

    @Override
    public DatagramDnsQuery setOpCode(DnsOpCode opCode) {
        return (DatagramDnsQuery) super.setOpCode(opCode);
    }

    @Override
    public DatagramDnsQuery setRecursionDesired(boolean recursionDesired) {
        return (DatagramDnsQuery) super.setRecursionDesired(recursionDesired);
    }

    @Override
    public DatagramDnsQuery setZ(int z) {
        return (DatagramDnsQuery) super.setZ(z);
    }

    @Override
    public DatagramDnsQuery setQuestion(DnsQuestion question) {
        return (DatagramDnsQuery) super.setQuestion(question);
    }

    @Override
    public DatagramDnsQuery setAdditionalRecord(DnsRecord record) {
        return (DatagramDnsQuery) super.setAdditionalRecord(record);
    }

    @Override
    public DatagramDnsQuery touch() {
        return (DatagramDnsQuery) super.touch();
    }

    @Override
    public DatagramDnsQuery touch(Object hint) {
        return (DatagramDnsQuery) super.touch(hint);
    }

    @Override
    public DatagramDnsQuery retain() {
        return (DatagramDnsQuery) super.retain();
    }

    @Override
    public DatagramDnsQuery retain(int increment) {
        return (DatagramDnsQuery) super.retain(increment);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof AddressedEnvelope)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        final AddressedEnvelope<?, SocketAddress> that = (AddressedEnvelope<?, SocketAddress>) obj;
        if (sender() == null) {
            if (that.sender() != null) {
                return false;
            }
        } else if (!sender().equals(that.sender())) {
            return false;
        }

        if (recipient() == null) {
            if (that.recipient() != null) {
                return false;
            }
        } else if (!recipient().equals(that.recipient())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
        if (sender() != null) {
            hashCode = hashCode * 31 + sender().hashCode();
        }
        if (recipient() != null) {
            hashCode = hashCode * 31 + recipient().hashCode();
        }
        return hashCode;
    }
}
