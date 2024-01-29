package OtherClasses;

import OtherClasses.Pieces.ConcretePiece;

public class Memory {
    private final Position _now;
    private final Position _last;
    private final ConcretePiece[] _killed;

    public Memory( Position now, Position last, ConcretePiece[] kills){
        this._now=now;
        this._last=last;
        this._killed=kills;
    }
    public Position get_now(){
        return _now;
    }
    public Position get_last(){
        return _last;
    }
    public ConcretePiece[] get_kills(){
        return _killed;
    }
}
