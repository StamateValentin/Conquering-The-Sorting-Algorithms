package window.side.events;

import controlP5.ControlEvent;

@FunctionalInterface
public interface ControlListener {
    void notify(ControlEvent event, int type);
}
