	function insertM(){
		document.location.href="insertM.jsp";
	}
	function editM(mid){
		document.location.href="control.jsp?action=editM&mid="+mid;
	}
	function delR(rid){
		document.location.href="control.jsp?action=deleteR&rid="+rid;
	}
	function myPage(){
		document.location.href="control.jsp?action=main";
	}
	function reg(){
		openWin();
	}
	function openWin(){
		window.open("reg.jsp","reg","width=300,height=300,resizable=no");
	}