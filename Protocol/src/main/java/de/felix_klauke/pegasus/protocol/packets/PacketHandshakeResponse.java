/*
 * Copyright 2016 Felix Klauke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.felix_klauke.pegasus.protocol.packets;

import de.felix_klauke.pegasus.protocol.Packet;
import de.felix_klauke.pegasus.protocol.PacketType;
import de.felix_klauke.pegasus.protocol.packets.wrapper.HandshakeResult;
import io.netty.buffer.ByteBuf;

/**
 * Created by Felix Klauke for project Pegasus on 14.02.2016.
 */
public class PacketHandshakeResponse extends Packet {

    /* ----------------------------------- [ Fields ] ----------------------------------- */

    /**
     * The result of the handshake
     */
    private HandshakeResult result;

    /* ----------------------------------- [ Constructors ] ----------------------------------- */

    /**
     * Standard Constructor. Will be used to handle incoming packet.
     */
    public PacketHandshakeResponse() {
        super(PacketType.HANDSHAKE_RESULT);
    }

    /**
     * Constructor to use when you want to send a packet. It will assign all given parameters.
     *
     * @param result the result of the handshake
     */
    public PacketHandshakeResponse(HandshakeResult result) {
        super(PacketType.HANDSHAKE_RESULT);
        this.result = result;
    }

    /* ----------------------------------- [ Methods ] ----------------------------------- */

    /**
     * @param byteBuf the bytebof to encode the packet in
     */
    @Override
    public void encode(ByteBuf byteBuf) {
        byteBuf.writeInt(result.getStatusID());
    }

    /**
     *
     * @param byteBuf the bytebof to decode the packet from
     */
    @Override
    public void decode(ByteBuf byteBuf) {
        result = HandshakeResult.lookup(byteBuf.readInt());
    }

    public HandshakeResult getResult() {
        return result;
    }

    public void setResult(HandshakeResult result) {
        this.result = result;
    }

}
