package cc.emotion.features.enums;

public enum RotateModes {
    Vanilla, // both rotate in client and server
    Client,
    Server,
    Random, // random pitch and yaw (bypass is not available in this mode)
    None // blocked all rotate from client, if player don't use any module, the p:0 & y:90
}
