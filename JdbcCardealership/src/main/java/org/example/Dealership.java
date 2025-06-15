package org.example;

    public class Dealership {
        private int dealership_Id;
        private String name;
        private String address;
        private String phone;

        public Dealership(){

        }
        public Dealership(int dealership_Id, String name, String address, String phone) {
            this.dealership_Id = dealership_Id;
            this.name = name;
            this.address = address;
            this.phone = phone;

        }
        public int getDealership_Id() {
            return dealership_Id;
        }

        public void setDealership_Id(int dealership_Id) {
            this.dealership_Id = dealership_Id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }


        @Override
        public String toString() {
            return "Dealership{" +
                    "dealership_Id=" + dealership_Id +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
