;(function($){
/**
 * jqGrid English Translation
 * Tony Tomov tony@trirand.com
 * http://trirand.com/blog/ 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
**/
$.jgrid = $.jgrid || {};
$.extend($.jgrid,{
	defaults : {
		recordtext: "当前 {0} - {1} 条 共 {2}条",
		emptyrecords: "无记录",
		loadtext: "加载中......",
		pgtext : " 当前{0}页  共 {1} 页"
	},
	search : {
		caption: "筛选框",
		Find: "检索",
		Reset: "重置",
		//odata: [{ oper:'eq', text:'equal'},{ oper:'ne', text:'not equal'},{ oper:'lt', text:'less'},{ oper:'le', text:'less or equal'},{ oper:'gt', text:'greater'},{ oper:'ge', text:'greater or equal'},{ oper:'bw', text:'begins with'},{ oper:'bn', text:'does not begin with'},{ oper:'in', text:'is in'},{ oper:'ni', text:'is not in'},{ oper:'ew', text:'ends with'},{ oper:'en', text:'does not end with'},{ oper:'cn', text:'contains'},{ oper:'nc', text:'does not contain'},{ oper:'nu', text:'is null'},{ oper:'nn', text:'is not null'}],
		odata: [{ oper:'eq', text:'等于'},{ oper:'ne', text:'不等于'},{ oper:'lt', text:'小与'},{ oper:'le', text:'小于等于'},{ oper:'gt', text:'大于'},{ oper:'ge', text:'大于等于'},{ oper:'bn', text:'大于'},{ oper:'bw', text:'大于等于'},{ oper:'cn', text:'模糊匹配'},{ oper:'nu', text:'为空'},{ oper:'ew', text:'小于等于'},{ oper:'en', text:'小于'},{ oper:'nn', text:'不为空'}],
		groupOps: [{ op: "AND", text: "全部" },{ op: "OR",  text: "或者" }],
		operandTitle : "单击以选择搜索操作.",
		resetTitle : "重置查询条件"
	},
	edit : {
		addCaption: "新增记录",
		editCaption: "编辑记录",
		bSubmit: "提交",
		bCancel: "结束",
		bClose: "关闭",
		saveData: "数据已更改！确认保存更改吗？",
		bYes : "是",
		bNo : "否",
		bExit : "结束",
		msg: {
			required:"字段是必需的",
			number:"请输入有效数字",
			minValue:"必须大于或等于",
			maxValue:"必须小于或等于",
			email: "不是有效的电子邮件",
			integer: "请输入有效的整数值",
			date: "请输入有效日期值",
			url: "是不是一个有效的网址。前缀要求 ('http://' or 'https://')",
			nodefined : "未定义！",
			novalue : "返回值是必需的！",
			customarray : "自定义函数应该返回数组！",
			customfcheck : "自定义函数应该是在自定义检查的情况下出现的！"
			
		}
	},
	view : {
		caption: "查看记录",
		bClose: "关闭"
	},
	del : {
		caption: "确认删除",
		msg: "确定要删除选中的行吗",
		bSubmit: "删除",
		bCancel: "结束"
	},
	nav : {
		edittext: "",
		edittitle: "编辑数据行",
		addtext:"",
		addtitle: "新增数据行",
		deltext: "",
		deltitle: "删除数据行",
		searchtext: "",
		searchtitle: "筛选查询",
		refreshtext: "",
		refreshtitle: "刷新表格",
		alertcap: "提示！",
		alerttext: "请选择需要操作的数据行",
		viewtext: "",
		viewtitle: "查看数据行"
	},
	col : {
		caption: "Select columns",
		bSubmit: "Ok",
		bCancel: "Cancel"
	},
	errors : {
		errcap : "Error",
		nourl : "No url is set",
		norecords: "No records to process",
		model : "Length of colNames <> colModel!"
	},
	formatter : {
		integer : {thousandsSeparator: ",", defaultValue: '0'},
		number : {decimalSeparator:".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00'},
		currency : {decimalSeparator:".", thousandsSeparator: ",", decimalPlaces: 2, prefix: "", suffix:"", defaultValue: '0.00'},
		date : {
			dayNames:   [
				"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat",
				"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
			],
			monthNames: [
				"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
				"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
			],
			AmPm : ["am","pm","AM","PM"],
			S: function (j) {return j < 11 || j > 13 ? ['st', 'nd', 'rd', 'th'][Math.min((j - 1) % 10, 3)] : 'th';},
			srcformat: 'Y-m-d',
			newformat: 'n/j/Y',
			parseRe : /[#%\\\/:_;.,\t\s-]/,
			masks : {
				// see http://php.net/manual/en/function.date.php for PHP format used in jqGrid
				// and see http://docs.jquery.com/UI/Datepicker/formatDate
				// and https://github.com/jquery/globalize#dates for alternative formats used frequently
				// one can find on https://github.com/jquery/globalize/tree/master/lib/cultures many
				// information about date, time, numbers and currency formats used in different countries
				// one should just convert the information in PHP format
				ISO8601Long:"Y-m-d H:i:s",
				ISO8601Short:"Y-m-d",
				// short date:
				//    n - Numeric representation of a month, without leading zeros
				//    j - Day of the month without leading zeros
				//    Y - A full numeric representation of a year, 4 digits
				// example: 3/1/2012 which means 1 March 2012
				ShortDate: "n/j/Y", // in jQuery UI Datepicker: "M/d/yyyy"
				// long date:
				//    l - A full textual representation of the day of the week
				//    F - A full textual representation of a month
				//    d - Day of the month, 2 digits with leading zeros
				//    Y - A full numeric representation of a year, 4 digits
				LongDate: "l, F d, Y", // in jQuery UI Datepicker: "dddd, MMMM dd, yyyy"
				// long date with long time:
				//    l - A full textual representation of the day of the week
				//    F - A full textual representation of a month
				//    d - Day of the month, 2 digits with leading zeros
				//    Y - A full numeric representation of a year, 4 digits
				//    g - 12-hour format of an hour without leading zeros
				//    i - Minutes with leading zeros
				//    s - Seconds, with leading zeros
				//    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
				FullDateTime: "l, F d, Y g:i:s A", // in jQuery UI Datepicker: "dddd, MMMM dd, yyyy h:mm:ss tt"
				// month day:
				//    F - A full textual representation of a month
				//    d - Day of the month, 2 digits with leading zeros
				MonthDay: "F d", // in jQuery UI Datepicker: "MMMM dd"
				// short time (without seconds)
				//    g - 12-hour format of an hour without leading zeros
				//    i - Minutes with leading zeros
				//    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
				ShortTime: "g:i A", // in jQuery UI Datepicker: "h:mm tt"
				// long time (with seconds)
				//    g - 12-hour format of an hour without leading zeros
				//    i - Minutes with leading zeros
				//    s - Seconds, with leading zeros
				//    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
				LongTime: "g:i:s A", // in jQuery UI Datepicker: "h:mm:ss tt"
				SortableDateTime: "Y-m-d\\TH:i:s",
				UniversalSortableDateTime: "Y-m-d H:i:sO",
				// month with year
				//    Y - A full numeric representation of a year, 4 digits
				//    F - A full textual representation of a month
				YearMonth: "F, Y" // in jQuery UI Datepicker: "MMMM, yyyy"
			},
			reformatAfterEdit : false
		},
		baseLinkUrl: '',
		showAction: '',
		target: '',
		checkbox : {disabled:true},
		idName : 'id'
	}
});
})(jQuery);
