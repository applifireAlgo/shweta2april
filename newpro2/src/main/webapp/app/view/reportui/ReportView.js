Ext.define('Newpro2.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Newpro2.view.reportui.querycriteria.QueryCriteriaView',
			'Newpro2.view.reportui.datachart.DataChartViewTab',
			'Newpro2.view.reportui.datachart.DataChartViewPanel',
			'Newpro2.view.reportui.ReportViewController' ,
			'Newpro2.view.fw.MainDataPointPanel',
			'Newpro2.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
