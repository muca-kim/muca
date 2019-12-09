package com.project.common;

public class Constants {
    public enum Role {
        ADMIN(0), GUEST(1), PERSONAL(2);

        Integer value;

        private Role(Integer num) {
            this.value = num;
        }

        public Integer getValue() {
            return value;
        }
    }

}