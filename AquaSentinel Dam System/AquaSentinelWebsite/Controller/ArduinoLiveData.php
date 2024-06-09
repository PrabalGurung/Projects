<?php

require_once('../Model/FarmData.php'); // Include the FarmData model class

class ArduinoLiveData {
    public static function getDataFromCSV($filename) {
        $last_five_data = []; // Array to store the last five FarmData objects
        
        // Open the CSV file for reading
        if (($handle = fopen($filename, "r")) !== false) {
            $total_lines = count(file($filename)); // Get total number of lines in the file
            $start_line = max(0, $total_lines - 5); // Calculate the starting line index
            
            // Skip lines until reaching the starting line
            for ($i = 0; $i < $start_line; $i++) {
                fgets($handle);
            }

            // Read the last five lines
            while (($row = fgetcsv($handle)) !== false) {
                $distance = isset($row[0]) ? $row[0] : null; // Check if the key exists before accessing it
                $water_storage = isset($row[1]) ? $row[1] : null;
                $agriculture_pump = isset($row[2]) ? $row[2] : null;
                $datetime = isset($row[3]) ? $row[3] : null; // Assuming datetime is in the 4th column

                // Create a new FarmData object and add it to the $last_five_data array
                $last_five_data[] = new FarmData($distance, $water_storage, $agriculture_pump, $datetime);
            }

            fclose($handle); // Close the file pointer
        }
        
        return $last_five_data;
    }
}

?>
