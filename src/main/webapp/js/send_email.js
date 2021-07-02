/*const SERVICE_ID = "send_email";
const TEMPLATE_ID = "placeorder_template";
async function sendEmail(to, dogNo) {
	const orderTemplateParams = {
		fromName: "krishna prasad raja",
		from: "17uecekamaraj@gmail.com",
		to,
		dogNo,
	};
	await emailjs
		.send(SERVICE_ID, TEMPLATE_ID, orderTemplateParams)
		.then(
			function(response) {
				alert("Email sent to "+ to);
			},
			function(error) {
				alert("FAILED..."+ error);
			}
		);
}*/

dogDetails.setDogImageByte(rs.getBinaryStream(1));
				dogDetails.set(rs.getString("dog_name"));
				dogDetails.setDogImageByte(rs.getInt("dog_age"));
				dogDetails.setDogImageByte(rs.getString("dog_gender"));
				dogDetails.setDogImageByte(rs.getString("dog_place"));
				dogDetails.setDogImageByte(rs.getInt("dog_price"));
				dogDetails.setDogImageByte(rs.getString("dog_insurance"));
