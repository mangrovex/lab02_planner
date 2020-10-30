package com.company.planner.web.screens.session;

import com.company.planner.entity.Session;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Calendar;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("planner_Session.browse")
@UiDescriptor("session-browse.xml")
@LookupComponent("sessionsTable")
@LoadDataBeforeShow
public class SessionBrowse extends StandardLookup<Session> {


    @Subscribe("calendarId01")
    public void onCalendarId01CalendarEventClick(Calendar.CalendarEventClickEvent<LocalDateTime> event) {

    }


}