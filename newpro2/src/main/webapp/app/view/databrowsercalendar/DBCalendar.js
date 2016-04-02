Ext.define('Newpro2.view.databrowsercalendar.DBCalendar', {
	extend : 'Newpro2.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Newpro2.view.databrowsercalendar.DBCalendarController',
	             'Newpro2.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
