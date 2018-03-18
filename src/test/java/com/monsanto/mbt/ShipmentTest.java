package com.monsanto.mbt;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ShipmentTest {

	@Test
	public void testShipment_Sorted_By_Color() {
		// To verify input list is null or not
		Assert.assertNotNull("List of widgets can't be null", WidgetUtils.getSampleWidgets());

		// To verify input list is empty or not
		Assert.assertFalse("List of widgets can't be empty", WidgetUtils.getSampleWidgets().isEmpty());

		Map<String, List<Widget>> shipments = Shipment.createShipmentByWidgetColor(WidgetUtils.getSampleWidgets());
		for (String color : shipments.keySet()) {
			// To verify the shipment with color is null or not
			Assert.assertNotNull("Shipment of Widgets with color: " + color + " can't be null", shipments.get(color));
			
			// To verify the shipment with color is empty or not
			Assert.assertFalse("Shipment of Widgets with color: " + color + " can't be empty",
					shipments.get(color).isEmpty());

			// To verify the shipment with color is contains more than 10 widgets or not
			Assert.assertFalse("Shipment of Widgets with color: " + color + " can't contain more than 10 widgets",
					(shipments.get(color).size() > Shipment.SHIPMENT_CAPACITY));
		}
	}

	@Test
	public void testShipment_Sorted_By_Date() {
		// To verify input list is null or not
		Assert.assertNotNull("List of widgets can't be null", WidgetUtils.getSampleWidgets());
		
		// To verify input list is empty or not
		Assert.assertFalse("List of widgets can't be blank", WidgetUtils.getSampleWidgets().isEmpty());
		Map<Date, List<Widget>> shipments = Shipment.createShipmentByProdDate(WidgetUtils.getSampleWidgets());

		for (Date prodDate : shipments.keySet()) {
			// To verify the shipment with production date is null or not
			Assert.assertNotNull("Shipment of Widget with ProductionDate: " + prodDate + " can't be null",
					shipments.get(prodDate));
			
			// To verify the shipment with production date is empty or not
			Assert.assertFalse("Shipment of Widgets with ProductionDatelor: " + prodDate + " can't be empty",
					shipments.get(prodDate).isEmpty());

			// To verify the shipment with production date is contains more than 10 widgets or not
			Assert.assertFalse(
					"Shipment of Widgets with ProductionDatelor: " + prodDate + " can't contain more than 10 widgets",
					(shipments.get(prodDate).size() > Shipment.SHIPMENT_CAPACITY));
		}
	}
}
