package com.iecisa.gtfsprocessor.logic.observer;

import com.iecisa.gtfsprocessor.logic.GtfsField;

public interface TransactionObserver
{
    default void onDownloaded() { }
    default void onProgress(float percentage) { }
    default void onFieldStart(GtfsField field, int entityCount) { }
    default void onFieldCommit(GtfsField field, int entityCount) { }
    default void onError(Exception exception) { }
}
