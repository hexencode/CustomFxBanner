module eu.hansolo.fx.customcontrols {
    // Java
    requires java.base;

    // Java-FX
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires java.logging;

    // Exports
    exports eu.hansolo.fx.customcontrols.restyled;
    exports eu.hansolo.fx.customcontrols.combined;
    exports eu.hansolo.fx.customcontrols.extended;
    exports eu.hansolo.fx.customcontrols.controlskinbased;
    exports eu.hansolo.fx.customcontrols.regionbased;
    exports eu.hansolo.fx.customcontrols.canvasbased;
    exports eu.hansolo.fx.customcontrols.tools;

    exports eu.hansolo.fx.customcontrols.customizedButton;
    exports eu.hansolo.fx.customcontrols.customizedButton2;
    exports eu.hansolo.fx.customcontrols.customizedButton3;
    exports eu.hansolo.fx.customcontrols.customizedButton4;

    exports eu.hansolo.fx.customcontrols.myStyleableButtons;

    exports eu.hansolo.fx.customcontrols.customizedBanner;
    exports eu.hansolo.fx.customcontrols.customizedBanner.mybanner;
}