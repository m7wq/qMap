package dev.m7wq.map;

import lombok.Getter;

@Getter
public enum Distance {
    ON_X{
        public void distance(int i){
            this.distance = i;
        }
    },
    ON_Y{
        public void distance(int i){
            this.distance = i;
        }
    },
    ON_Z{
        public void distance(int i){
            this.distance = i;
        }
    };

    int distance;





}
