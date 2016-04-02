Ext.define('Newpro2.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Newpro2.view.reportui.datachart.DataChartTController',
	             'Newpro2.view.reportui.datachart.datagrid.DataGridView',
	             'Newpro2.view.reportui.datachart.chart.ChartTabView',
	             'Newpro2.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});