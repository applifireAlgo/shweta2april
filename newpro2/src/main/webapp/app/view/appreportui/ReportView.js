Ext.define('Newpro2.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Newpro2.view.appreportui.ReportViewController',
	            'Newpro2.view.appreportui.datagrid.DataGridPanel',
	            'Newpro2.view.appreportui.datagrid.DataGridView',
	            'Newpro2.view.appreportui.querycriteria.QueryCriteriaView',
	            'Newpro2.view.appreportui.chart.ChartView',
	            'Newpro2.view.appreportui.datapoint.DataPointView',
	            'Newpro2.view.googlemaps.map.MapPanel',
	            'Newpro2.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
