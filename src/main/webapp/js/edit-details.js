function show(serial){
	
	let edit = document.getElementById("editBtn" +serial);
	let done = document.getElementById("okBtn" + serial);
	if(edit.style.display === "block"){
		
		edit.style.display = "none";
		done.style.display = "block";
	} else{
		
		edit.style.display = "block";
		done.style.display = "none";
	}
}

function callFunction(serial, option) {
	let phoneNo = document.getElementById("phoneNo" + serial);
	let address = document.getElementById("address" + serial);
	let id = phoneNo.getAttribute("data-orderId");
	let oldMobileNumber = phoneNo.getAttribute("data-mobileNumber");
	let oldAddress = address.getAttribute("data-address");
	switch (option) {
		case 1:
			phoneNo.readOnly = false;
			address.readOnly = false;
			show(serial);
			break;
		case 2:
			if (phoneNo.value === oldMobileNumber && address.value === oldAddress) {

				window.alert("Nothing is change");
			} else if (phoneNo.value.trim() == "" || address.value.trim() == "") {

				window.alert("No empty filed");
			} else {

				let editedObj = {
					phnoneNo: phoneNo.value,
					address: address.value,
					orderId: id
				};
				let editedJson = JSON.stringify(editedObj);

				$.ajax({
					url: 'OrderEditServlet',
					type: 'GET',
					data: {
						dt: editedJson
					}
				})
				show(serial);
			}
			break;
		case 3:
			console.log("3");
			phoneNo.value = oldMobileNumber;
			address.value = oldAddress;
			phoneNo.readOnly = true;
			address.readOnly = true;
			show(serial);
			break;

	}
}