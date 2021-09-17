	function insertM(){
		document.location.href="insertM.jsp";
	}
	function editM(mid){
		document.location.href="editM.do?mid="+mid;
	}
	function delR(rid){
		document.location.href="deleteR.do?rid="+rid;
	}
	function myPage(){
		document.location.href="main.do";
	}
	function reg(){
		openWin();
	}
	function openWin(){
		window.open("reg.jsp","reg","width=300,height=300,resizable=no");
	}