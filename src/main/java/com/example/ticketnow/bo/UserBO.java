package com.example.ticketnow.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;
import java.util.Set;

@Data
public class UserBO {

        private String userId;
        private String password;
        private Set<String> roles;
   //     @JsonIgnore
        private String username;

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                UserBO userBO = (UserBO) o;
                return Objects.equals(userId, userBO.userId) && Objects.equals(password, userBO.password);
        }

        @Override
        public int hashCode() {
                return Objects.hash(userId, password, roles);
        }
}
