package net.wdfeer.androidgame1;

import androidx.annotation.Nullable;

public class V2i {
    public int x;
    public int y;
    public V2i(int x, int y){ this.x = x; this.y = y; }

    @Override
    public boolean equals(@Nullable @org.jetbrains.annotations.Nullable Object obj) {
        if (!(obj instanceof V2i))
            return false;
        V2i other = (V2i)obj;
        return other.x == x && other.y == y;
    }
}
