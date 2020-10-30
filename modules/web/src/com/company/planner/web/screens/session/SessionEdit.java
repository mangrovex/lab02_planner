package com.company.planner.web.screens.session;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.planner.entity.Session;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("planner_Session.edit")
@UiDescriptor("session-edit.xml")
@EditedEntityContainer("sessionDc")
@LoadDataBeforeShow
public class SessionEdit extends StandardEditor<Session> {

    @Inject
    private TextField<Integer> durationField;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Session> event) {
        event.getEntity().setDuration(1);
        durationField.setFocusable(true);
        event.getEntity().setStartDate(LocalDateTime.now());
    }

   
}