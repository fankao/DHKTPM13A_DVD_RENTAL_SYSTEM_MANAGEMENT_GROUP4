package com.group4.entities;

public enum TrangThaiDia {
	ON_SHEFT{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Còn đĩa";
		}
	},
	RENTED{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Đã được thuê";
		}
	}
	,
	ON_HOLD{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Đã được gán";
		}
	};
}
