package com.pitang.projetomovie.projetomovie.Infraestrutura;

import java.io.Serializable;

public interface IObjectPersistent<T> extends Serializable {

    T getId();

}
