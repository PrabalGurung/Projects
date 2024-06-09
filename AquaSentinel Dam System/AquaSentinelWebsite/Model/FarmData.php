<?php

class FarmData {
    private $distance;
    private $water_storage;
    private $agriculture_pump;
    private $datetime;

    // Constructor
    public function __construct($distance, $water_storage, $agriculture_pump, $datetime) {
        $this->distance = $distance;
        $this->water_storage = $water_storage;
        $this->agriculture_pump = $agriculture_pump;
        $this->datetime = $datetime;
    }

    // Getters
    public function getDistance() {
        return $this->distance;
    }

    public function getWaterStorage() {
        return $this->water_storage;
    }

    public function getAgriculturePump() {
        return $this->agriculture_pump;
    }

    public function getDatetime() {
        return $this->datetime;
    }

    // Setters
    public function setDistance($distance) {
        $this->distance = $distance;
    }

    public function setWaterStorage($water_storage) {
        $this->water_storage = $water_storage;
    }

    public function setAgriculturePump($agriculture_pump) {
        $this->agriculture_pump = $agriculture_pump;
    }

    public function setDatetime($datetime) {
        $this->datetime = $datetime;
    }
}

?>
