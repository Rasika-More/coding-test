package com.monsanto.mbt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shipment {

	public static final int SHIPMENT_CAPACITY = 10;

	/**
	 * @Moto: To Create Shipment of Widget by their color
	 * @param widgetList
	 * @return Map<String, List<Widget>>
	 */
	public static Map<String, List<Widget>> createShipmentByWidgetColor(List<Widget> widgetList) {
		Map<String, List<Widget>> colorWidgettMap = new HashMap<String, List<Widget>>();
		for (Widget widget : widgetList) {
			if (null == colorWidgettMap.get(widget.getColor())) {
				List<Widget> wList = new ArrayList<Widget>(10);
				wList.add(widget);
				colorWidgettMap.put(widget.getColor(), wList);
			} else {
				if (colorWidgettMap.get(widget.getColor()).size() < SHIPMENT_CAPACITY) {
					List<Widget> wList = colorWidgettMap.get(widget.getColor());
					wList.add(widget);
				}
			}
		}
		return colorWidgettMap;
	}

	/**
	 * @Moto: To Create Shipment of Widget by their Production Date
	 * @param widgetList
	 * @return Map<Date, List<Widget>>
	 */
	public static Map<Date, List<Widget>> createShipmentByProdDate(List<Widget> widgetList) {
		Map<Date, List<Widget>> dateWidgettMap = new HashMap<Date, List<Widget>>();
		for (Widget widget : widgetList) {
			if (null == dateWidgettMap.get(widget.getProductionDate())) {
				List<Widget> wList = new ArrayList<Widget>(10);
				wList.add(widget);
				dateWidgettMap.put(widget.getProductionDate(), wList);
			} else {
				if (dateWidgettMap.get(widget.getProductionDate()).size() < SHIPMENT_CAPACITY) {
					List<Widget> wList = dateWidgettMap.get(widget.getProductionDate());
					wList.add(widget);
				}
			}
		}
		return dateWidgettMap;
	}
}
