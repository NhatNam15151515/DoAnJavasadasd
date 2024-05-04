package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class XaPhuong {
	// Khai báo một HashMap để ánh xạ từ tên quận sang mảng quận tương ứng
	private Map<String, String[]> xaPhuongMap;

	public XaPhuong() {
		// Khởi tạo HashMap và thêm các cặp key-value tương ứng
		xaPhuongMap = new HashMap<>();
		xaPhuongMap.put("quan1",
				new String[] { "Phường Bến Nghé", "Phường Bến Thành", "Phường Cô Giang", "Phường Cầu Kho",
						"Phường Cầu Ông Lãnh", "Phường Đa Kao", "Phường Nguyễn Thái Bình", "Phường Nguyễn Cư Trinh",
						"Phường Phạm Ngũ Lão", "Phường Tân Định" });

		xaPhuongMap.put("quan2",
				new String[] { "Phường An Khánh", "Phường An Lợi Đông", "Phường An Phú", "Phường Bình An",
						"Phường Bình Khánh", "Phường Bình Trưng Đông", "Phường Bình Trưng Tây", "Phường Cát Lái",
						"Phường Thạnh Mỹ Lợi", "Phường Thảo Điền", "Phường Thủ Thiêm" });

		xaPhuongMap.put("quan3", new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6",
				"Phường 7", "Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14" });

		xaPhuongMap.put("quan4",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6", "Phường 8",
						"Phường 9", "Phường 10", "Phường 12", "Phường 13", "Phường 14", "Phường 15", "Phường 16",
						"Phường 18" });

		xaPhuongMap.put("quan5",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6", "Phường 7",
						"Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14",
						"Phường 15" });

		xaPhuongMap.put("quan6", new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6",
				"Phường 7", "Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14" });

		xaPhuongMap.put("quan7",
				new String[] { "Phường Bình Thuận", "Phường Phú Mỹ", "Phường Phú Thuận", "Phường Tân Hưng",
						"Phường Tân Phong", "Phường Tân Phú", "Phường Tân Kiểng", "Phường Tân Quy",
						"Phường Tân Thuận Đông", "Phường Tân Thuận Tây" });

		xaPhuongMap.put("quan8",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6", "Phường 7",
						"Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14",
						"Phường 15", "Phường 16" });

		xaPhuongMap.put("quan9",
				new String[] { "Phường Hiệp Phú", "Phường Long Bình", "Phường Long Phước", "Phường Long Trường",
						"Phường Long Thạnh Mỹ", "Phường Phú Hữu", "Phường Phước Bình", "Phường Phước Long A",
						"Phường Phước Long B", "Phường Tăng Nhơn Phú A", "Phường Tăng Nhơn Phú B", "Phường Tân Phú",
						"Phường Trường Thạnh" });

		xaPhuongMap.put("quan10",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6", "Phường 7",
						"Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14",
						"Phường 15" });

		xaPhuongMap.put("quan11",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6", "Phường 7",
						"Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14",
						"Phường 15", "Phường 16" });

		xaPhuongMap.put("quan12",
				new String[] { "Phường An Phú Đông", "Phường Đông Hưng Thuận", "Phường Hiệp Thành",
						"Phường Tân Chánh Hiệp", "Phường Tân Thới Hiệp", "Phường Tân Thới Nhất", "Phường Thạnh Lộc",
						"Phường Thạnh Xuân", "Phường Thới An", "Phường Trung Mỹ Tây", "Phường Tân Hưng Thuận" });

		xaPhuongMap.put("quanthuduc", new String[] { "Phường Bình Chiểu", "Phường Bình Thọ", "Phường Hiệp Bình Chánh",
				"Phường Hiệp Bình Phước", "Phường Linh Chiểu", "Phường Linh Đông", "Phường Linh Tây",
				"Phường Linh Trung", "Phường Linh Xuân", "Phường Tam Bình", "Phường Tam Phú", "Phường Trường Thọ" });
		
		xaPhuongMap.put("quangovap",
				new String[] { "Phường 01", "Phường 03", "Phường 04", "Phường 05", "Phường 06", "Phường 07",
						"Phường 08", "Phường 09", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14",
						"Phường 15", "Phường 16", "Phường 17" });
		
		xaPhuongMap.put("quantanphu",
				new String[] { "Phường Hòa Thạnh", "Phường Hiệp Tân", "Phường Phú Thạnh", "Phường Phú Thọ Hòa",
						"Phường Phú Trung", "Phường Sơn Kỳ", "Phường Tân Thành", "Phường Tân Thới Hòa",
						"Phường Tân Quý", "Phường Tân Sơn Nhì", "Phường Tây Thạnh" });

		xaPhuongMap.put("quanbinhtan",
				new String[] { "Phường An Lạc", "Phường An Lạc A", "Phường Bình Hưng Hòa", "Phường Bình Hưng Hòa A",
						"Phường Bình Hưng Hòa B", "Phường Bình Trị Đông", "Phường Bình Trị Đông A",
						"Phường Bình Trị Đông B", "Phường Tân Tạo", "Phường Tân Tạo A" });

		xaPhuongMap.put("quanphunhuan",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 7", "Phường 8",
						"Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14", "Phường 15",
						"Phường 17" });

		xaPhuongMap.put("quantanbinh",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 4", "Phường 5", "Phường 6", "Phường 7",
						"Phường 8", "Phường 9", "Phường 10", "Phường 11", "Phường 12", "Phường 13", "Phường 14",
						"Phường 15" });

		xaPhuongMap.put("quanbinhthanh",
				new String[] { "Phường 1", "Phường 2", "Phường 3", "Phường 5", "Phường 6", "Phường 7", "Phường 11",
						"Phường 12", "Phường 13", "Phường 14", "Phường 15", "Phường 17", "Phường 19", "Phường 21",
						"Phường 22", "Phường 24", "Phường 25", "Phường 26", "Phường 27", "Phường 28" });

		xaPhuongMap.put("huyencangio", new String[] { "Thị trấn Cần Thạnh", "Xã Thạnh An", "Xã Long Hòa", "Xã Lý Nhơn",
				"Xã Tam Thôn Hiệp", "Xã An Thới Đông", "Xã Bình Khánh" });

		xaPhuongMap.put("huyencuchi",
				new String[] { "Thị trấn Củ Chi", "Xã Trung Lập Thượng", "Xã Trung Lập Hạ", "Xã Thái Mỹ",
						"Xã Tân Thông Hội", "Xã Tân Thạnh Tây", "Xã Tân Thạnh Đông", "Xã Tân Phú Trung",
						"Xã Tân An Hội", "Xã Phước Vĩnh An", "Xã Phước Hiệp", "Xã Phước Thạnh", "Xã Phú Hòa Đông",
						"Xã Phú Mỹ Hưng", "Xã Phạm Văn Cội", "Xã Nhuận Đức", "Xã Bình Mỹ", "Xã An Phú",
						"Xã An Nhơn Tây", "Xã Trung An", "Xã Hòa Phú" });

		xaPhuongMap.put("huyenbinhchanh",
				new String[] { "Thị trấn Tân Túc", "Xã Tân Kiên", "Xã Vĩnh Lộc A", "Xã Vĩnh Lộc B", "Xã Tân Quý Tây",
						"Xã Tân Nhựt", "Xã Qui Đức", "Xã Phong Phú", "Xã Phạm Văn Hai", "Xã Lê Minh Xuân",
						"Xã Hưng Long", "Xã Đa Phước", "Xã Bình Lợi", "Xã Bình Hưng", "Xã Bình Chánh",
						"Xã An Phú Tây" });

		xaPhuongMap.put("huyenhocmon",
				new String[] { "Thị trấn Hóc Môn", "Xã Bà Điểm", "Xã Đông Thạnh", "Xã Nhị Bình", "Xã Tân Hiệp",
						"Xã Tân Thới Nhì", "Xã Tân Xuân", "Xã Thới Tam Thôn", "Xã Trung Chánh", "Xã Xuân Thới Đông",
						"Xã Xuân Thới Sơn", "Xã Xuân Thới Thượng" });

		xaPhuongMap.put("huyennhabe", new String[] { "Thị trấn Nhà Bè", "Xã Phú Xuân", "Xã Long Thới", "Xã Hiệp Phước",
				"Xã Nhơn Đức", "Xã Phước Lộc", "Xã Phước Kiển" });
	}

	public Map<String, String[]> getxaPhuongMap() {
		return xaPhuongMap;
	}

	public String[] allMap() {
		Set<String> uniqueValuesSet = new HashSet<>();

		for (String[] values : xaPhuongMap.values()) {
			uniqueValuesSet.addAll(Arrays.asList(values));
		}

		// Chuyển đổi set thành mảng String
		String[] uniqueValuesArray = uniqueValuesSet.toArray(new String[0]);

		// Sắp xếp mảng String
		Arrays.sort(uniqueValuesArray);

		// Tạo một ArrayList từ mảng đã sắp xếp
		ArrayList<String> resultList = new ArrayList<>(Arrays.asList(uniqueValuesArray));

		// Thêm "Tất cả" vào đầu ArrayList
		resultList.add(0, "Tất cả");

		// Chuyển đổi ArrayList thành mảng String
		return resultList.toArray(new String[0]);
	}

	/*
	 * public static void main(String[] args) { XaPhuong xaPhuong = new XaPhuong();
	 * // Lấy quận 1 String[] xaPhuong1 =
	 * xaPhuong.getxaPhuongMap().get("xaPhuongBinhTan"); // In ra danh sách các
	 * phường thuộc quận 1 System.out.println("Các phường thuộc quận 1:"); for
	 * (String phuong : xaPhuong1) { System.out.println(phuong); } }
	 */
}
