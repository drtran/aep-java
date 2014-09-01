describe("Hello world", function() {
	it("should say 'Hello world'", function() {
		expect(helloWorld()).toEqual("Hello world");
	});
	
	it ("should not say 'Hello!'", function() {
		expect(helloWorld()).not.toEqual("Hello!");
	});
});