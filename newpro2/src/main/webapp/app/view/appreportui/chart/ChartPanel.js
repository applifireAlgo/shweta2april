Ext.define('Newpro2.view.appreportui.chart.ChartPanel', {
	extend : 'Ext.panel.Panel',
	requires:['Newpro2.view.appreportui.chart.ChartPanelController'],
	controller:'chartPanelController',
	xtype : 'chartPanel',
	chartJson:null,
	title:'Panel',
	layout:{
		type:'fit',
		align:'center',
		pack:'center'
	},
	listeners:{
		afterrender:'chartPanelAfterRender'
	}
});