package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		String printOrders = "======Printing Orders======\n";
		output.append(printOrders);


        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

		double totSalesTax = 0d;
		double totAmount = 0d;
		double salesTaxRate = .10d;
		for (LineItem lineItem : order.getLineItems()) {
			outputAppend(output, lineItem);

			double salesTax = lineItem.totalAmount() * salesTaxRate;
            totSalesTax += salesTax;
            totAmount += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totSalesTax);
		output.append("Total Amount").append('\t').append(totAmount);
		return output.toString();
	}

	private void outputAppend(StringBuilder output, LineItem lineItem) {
		output.append(lineItem.getDescription());
		output.append('\t');
		output.append(lineItem.getPrice());
		output.append('\t');
		output.append(lineItem.getQuantity());
		output.append('\t');
		output.append(lineItem.totalAmount());
		output.append('\n');
	}
}
