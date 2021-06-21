module intechcoreFxControls {
    // Java
    requires java.base;

    // Java-FX
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires java.logging;

    // Exports
    exports com.jankotek.fx.customcontrols;
    exports com.jankotek.fx.customcontrols.mybanner;
}