Java Script Trim() function

    function fnTrim() {
     for(var L=0; L     if(this.charAt(L)!=" ")break;
     for(R=this.length-1; R>=0;R--)
     if(this.charAt(R)!=" ")break; 
     if(L==this.length)return ""; 
     return this.substring(L,R+1);
}
String.prototype.trim=fnTrim;
//**** For trim the crtl 

    if ((document.frm.crtlName.value).trim()=="") { 
    //*** Here ur code 
    
}
