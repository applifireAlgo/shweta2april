Ext.define('Newpro2.newpro2.web.com.view.salesboundedcontext.sales.SalesDataMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "SalesDataMainController",
     "restURL": "/SalesData",
     "defaults": {
          "split": true
     },
     "requires": ["Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.SalesDataModel", "Newpro2.newpro2.web.com.controller.salesboundedcontext.sales.SalesDataMainController", "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.ChannelModel", "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.RetailerModel", "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.MaterialModel", "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.BrandModel", "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.CategoryModel", "Newpro2.newpro2.shared.com.viewmodel.salesboundedcontext.sales.SalesDataViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "SalesData",
               "name": "SalesDataTreeContainer",
               "itemId": "SalesDataTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "SalesDataTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "SalesData",
                    "name": "SalesData",
                    "itemId": "SalesDataForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "autoid",
                                   "itemId": "autoid",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Auto Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Auto Id<font color='red'> *<\/font>",
                                   "fieldId": "60139517-E265-4024-B5B6-6627F6C327B2",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "autoid"
                              }, {
                                   "name": "channelId",
                                   "itemId": "channelId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Channel",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.ChannelModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Channel<font color='red'> *<\/font>",
                                   "fieldId": "C36B9F4C-93EE-453F-A64B-D6882F55C217",
                                   "restURL": "Channel",
                                   "bindable": "channelId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "reatilercode",
                                   "itemId": "reatilercode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Retailer",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.RetailerModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Retailer<font color='red'> *<\/font>",
                                   "fieldId": "44DBC06E-9B36-4085-B840-652229FCD40A",
                                   "restURL": "Retailer",
                                   "bindable": "reatilercode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "retailername",
                                   "itemId": "retailername",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Retailer name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Retailer name",
                                   "fieldId": "A45CE0FF-4D70-4947-830D-C80D30982A7A",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "retailername",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "salesdate",
                                   "itemId": "salesdate",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Sales Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Sales Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "F5974148-1D07-45A8-91FC-B42F66F67834",
                                   "bindable": "salesdate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "salesmonth",
                                   "itemId": "salesmonth",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales Month",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales Month<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E9936610-1705-4A88-86BC-8374F03D1EA9",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "salesmonth",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "salesyear",
                                   "itemId": "salesyear",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales Year",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales Year<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "F600621C-0228-4CC8-861F-08C44BC5BC57",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "salesyear",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "salesinvoicenbr",
                                   "itemId": "salesinvoicenbr",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Invoice Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Invoice Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "0D0FA3D9-6DB9-4592-83E1-D5BAF71AC38F",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "salesinvoicenbr",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "materialdesc",
                                   "itemId": "materialdesc",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Material Desc",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Material Desc",
                                   "fieldId": "26852D5D-87FC-4E90-8D81-FDB6B3994997",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "materialdesc",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "branddesc",
                                   "itemId": "branddesc",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Brand Desc",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Brand Desc",
                                   "fieldId": "B0FB1AFB-4B85-4C47-B69B-1B7C765175A3",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "branddesc",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "salesqty",
                                   "itemId": "salesqty",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales Quantity",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales Quantity<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C3C08A70-0691-4025-9D41-37EDA10667D0",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "salesqty",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "netsalesamt",
                                   "itemId": "netsalesamt",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Net Sales",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Net Sales<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "7D911FA6-A94F-44DE-9DFE-F24F52EF68C6",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "netsalesamt",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "grosssalesamt",
                                   "itemId": "grosssalesamt",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Gross Sales",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Gross Sales<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "F118BEC1-7A6F-43E7-AE37-9999E586E523",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "grosssalesamt",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "materialcode",
                                   "itemId": "materialcode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Material",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.MaterialModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Material<font color='red'> *<\/font>",
                                   "fieldId": "81D6A7E8-E18F-47B2-B149-FB1766550177",
                                   "restURL": "Material",
                                   "bindable": "materialcode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "brandcode",
                                   "itemId": "brandcode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Brand",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.BrandModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Brand<font color='red'> *<\/font>",
                                   "fieldId": "81F804AB-0DEB-4B53-93DD-05C1452C1F18",
                                   "restURL": "Brand",
                                   "bindable": "brandcode",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onBrandcodeChange"
                                   }
                              }, {
                                   "name": "category",
                                   "itemId": "category",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Category",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.CategoryModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Category<font color='red'> *<\/font>",
                                   "fieldId": "3F3238F4-4361-401F-A1D2-D542643865FC",
                                   "restURL": "Category",
                                   "bindable": "category",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "0F99E3B6-6749-431D-BA71-6E4A2304A08D",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "SalesData",
                    "title": "Details Grid",
                    "name": "SalesDataGrid",
                    "itemId": "SalesDataGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Auto Id",
                         "dataIndex": "autoid",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Channel",
                         "dataIndex": "channelId",
                         "flex": 1
                    }, {
                         "header": "Retailer",
                         "dataIndex": "reatilercode",
                         "flex": 1
                    }, {
                         "header": "Retailer name",
                         "dataIndex": "retailername",
                         "flex": 1
                    }, {
                         "header": "Sales Date",
                         "dataIndex": "salesdate",
                         "flex": 1
                    }, {
                         "header": "Sales Month",
                         "dataIndex": "salesmonth",
                         "flex": 1
                    }, {
                         "header": "Sales Year",
                         "dataIndex": "salesyear",
                         "flex": 1
                    }, {
                         "header": "Invoice Number",
                         "dataIndex": "salesinvoicenbr",
                         "flex": 1
                    }, {
                         "header": "Material Desc",
                         "dataIndex": "materialdesc",
                         "flex": 1
                    }, {
                         "header": "Brand Desc",
                         "dataIndex": "branddesc",
                         "flex": 1
                    }, {
                         "header": "Sales Quantity",
                         "dataIndex": "salesqty",
                         "flex": 1
                    }, {
                         "header": "Net Sales",
                         "dataIndex": "netsalesamt",
                         "flex": 1
                    }, {
                         "header": "Gross Sales",
                         "dataIndex": "grosssalesamt",
                         "flex": 1
                    }, {
                         "header": "Material",
                         "dataIndex": "materialcode",
                         "flex": 1
                    }, {
                         "header": "Brand",
                         "dataIndex": "brandcode",
                         "flex": 1
                    }, {
                         "header": "Category",
                         "dataIndex": "category",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "SalesData",
               "name": "SalesData",
               "itemId": "SalesDataForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "autoid",
                              "itemId": "autoid",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Auto Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Auto Id<font color='red'> *<\/font>",
                              "fieldId": "60139517-E265-4024-B5B6-6627F6C327B2",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "hidden": true,
                              "value": "",
                              "bindable": "autoid"
                         }, {
                              "name": "channelId",
                              "itemId": "channelId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Channel",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.ChannelModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Channel<font color='red'> *<\/font>",
                              "fieldId": "C36B9F4C-93EE-453F-A64B-D6882F55C217",
                              "restURL": "Channel",
                              "bindable": "channelId",
                              "columnWidth": 0.5
                         }, {
                              "name": "reatilercode",
                              "itemId": "reatilercode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Retailer",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.RetailerModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Retailer<font color='red'> *<\/font>",
                              "fieldId": "44DBC06E-9B36-4085-B840-652229FCD40A",
                              "restURL": "Retailer",
                              "bindable": "reatilercode",
                              "columnWidth": 0.5
                         }, {
                              "name": "retailername",
                              "itemId": "retailername",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Retailer name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Retailer name",
                              "fieldId": "A45CE0FF-4D70-4947-830D-C80D30982A7A",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "retailername",
                              "columnWidth": 0.5
                         }, {
                              "name": "salesdate",
                              "itemId": "salesdate",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Sales Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Sales Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F5974148-1D07-45A8-91FC-B42F66F67834",
                              "bindable": "salesdate",
                              "columnWidth": 0.5
                         }, {
                              "name": "salesmonth",
                              "itemId": "salesmonth",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales Month",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales Month<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E9936610-1705-4A88-86BC-8374F03D1EA9",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "salesmonth",
                              "columnWidth": 0.5
                         }, {
                              "name": "salesyear",
                              "itemId": "salesyear",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales Year",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales Year<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F600621C-0228-4CC8-861F-08C44BC5BC57",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "salesyear",
                              "columnWidth": 0.5
                         }, {
                              "name": "salesinvoicenbr",
                              "itemId": "salesinvoicenbr",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Invoice Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Invoice Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "0D0FA3D9-6DB9-4592-83E1-D5BAF71AC38F",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "salesinvoicenbr",
                              "columnWidth": 0.5
                         }, {
                              "name": "materialdesc",
                              "itemId": "materialdesc",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Material Desc",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Material Desc",
                              "fieldId": "26852D5D-87FC-4E90-8D81-FDB6B3994997",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "materialdesc",
                              "columnWidth": 0.5
                         }, {
                              "name": "branddesc",
                              "itemId": "branddesc",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Brand Desc",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Brand Desc",
                              "fieldId": "B0FB1AFB-4B85-4C47-B69B-1B7C765175A3",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "branddesc",
                              "columnWidth": 0.5
                         }, {
                              "name": "salesqty",
                              "itemId": "salesqty",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales Quantity",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales Quantity<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C3C08A70-0691-4025-9D41-37EDA10667D0",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "salesqty",
                              "columnWidth": 0.5
                         }, {
                              "name": "netsalesamt",
                              "itemId": "netsalesamt",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Net Sales",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Net Sales<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "7D911FA6-A94F-44DE-9DFE-F24F52EF68C6",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "netsalesamt",
                              "columnWidth": 0.5
                         }, {
                              "name": "grosssalesamt",
                              "itemId": "grosssalesamt",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Gross Sales",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Gross Sales<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F118BEC1-7A6F-43E7-AE37-9999E586E523",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "grosssalesamt",
                              "columnWidth": 0.5
                         }, {
                              "name": "materialcode",
                              "itemId": "materialcode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Material",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.MaterialModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Material<font color='red'> *<\/font>",
                              "fieldId": "81D6A7E8-E18F-47B2-B149-FB1766550177",
                              "restURL": "Material",
                              "bindable": "materialcode",
                              "columnWidth": 0.5
                         }, {
                              "name": "brandcode",
                              "itemId": "brandcode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Brand",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.BrandModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Brand<font color='red'> *<\/font>",
                              "fieldId": "81F804AB-0DEB-4B53-93DD-05C1452C1F18",
                              "restURL": "Brand",
                              "bindable": "brandcode",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onBrandcodeChange"
                              }
                         }, {
                              "name": "category",
                              "itemId": "category",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Category",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro2.newpro2.shared.com.model.salesboundedcontext.sales.CategoryModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Category<font color='red'> *<\/font>",
                              "fieldId": "3F3238F4-4361-401F-A1D2-D542643865FC",
                              "restURL": "Category",
                              "bindable": "category",
                              "columnWidth": 0.5
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "0F99E3B6-6749-431D-BA71-6E4A2304A08D",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});