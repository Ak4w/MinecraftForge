package net.minecraftforge.common;

import java.util.Map;
import java.util.UUID;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;

import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

//To be expanded for generic Mod fake players?
public class FakePlayerFactory
{
    private static GameProfile MINECRAFT = new GameProfile("41C82C87-7AfB-4024-BA57-13D2C99CAE77", "[Minecraft]");
    // Map of all active fake player usernames to their entities
    private static Map<GameProfile, FakePlayer> fakePlayers = Maps.newHashMap();
    private static FakePlayer MINECRAFT_PLAYER = null;
    
    public static FakePlayer getMinecraft(WorldServer world)
    {
        if (MINECRAFT_PLAYER == null)
        {
            MINECRAFT_PLAYER = FakePlayerFactory.get(world,  MINECRAFT);
        }
        return MINECRAFT_PLAYER;
    }
    
    /**
     * Get a fake player with a given username
     */
    public static FakePlayer get(WorldServer world, GameProfile username)
    {
        if (!fakePlayers.containsKey(username))
        {
            FakePlayer fakePlayer = new FakePlayer(world, username);
            fakePlayers.put(username, fakePlayer);
        }

        return fakePlayers.get(username);
    }
}
