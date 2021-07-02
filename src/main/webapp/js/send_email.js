const SERVICE_ID = "send_email";
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
}