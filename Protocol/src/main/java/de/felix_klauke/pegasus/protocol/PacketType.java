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

package de.felix_klauke.pegasus.protocol;

import de.felix_klauke.pegasus.protocol.packets.PacketHandshake;
import de.felix_klauke.pegasus.protocol.packets.PacketHandshakeResponse;
import de.felix_klauke.pegasus.protocol.packets.PacketMessage;

/**
 * Created by Felix Klauke for project Pegasus on 14.02.2016.
 */
public enum PacketType {

    /* ----------------------------------- [ Enumeration ] ----------------------------------- */

    HANDSHAKE(PacketHandshake.class, 0),
    HANDSHAKE_RESULT(PacketHandshakeResponse.class, 1),
    MESSAGE(PacketMessage.class, 2);

    /* ----------------------------------- [ Fields ] ----------------------------------- */

    /**
     * The class the packet is defined in
     */
    private final Class<? extends Packet> packetClass;

    /**
     * The uniqueID of the Packet
     */
    private final int packetID;

    /* ----------------------------------- [ Constructors ] ----------------------------------- */

    /**
     * @param packetClass the class the packet is defined in
     * @param packetID    the uniqueID of the Packet
     */
    PacketType(Class<? extends Packet> packetClass, int packetID) {
        this.packetClass = packetClass;
        this.packetID = packetID;
    }

    /* ----------------------------------- [ Methods ] ----------------------------------- */

    /**
     *
     * Institate incoming Packet with this Method
     *
     * @param packetID th id of the packet
     * @return and instance of the packet with the given id
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Packet lookup(int packetID) throws IllegalAccessException, InstantiationException {
        for (PacketType packetType : values()) {
            if (packetType.getPacketID() == packetID) return packetType.getPacketClass().newInstance();
        }
        return null;
    }

    public static String getVersion() {
        return "1";
    }

    public int getPacketID() {
        return packetID;
    }

    public Class<? extends Packet> getPacketClass() {
        return packetClass;
    }
}
