<?php
// DatabaseController.php

// Database connection details
$servername = "localhost";
$username = "root"; // Default XAMPP MySQL username
$password = ""; // Default XAMPP MySQL password (empty)
$dbname = "aquasentinel";

// Check if the form was submitted via POST method
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get form parameters
    $name = isset($_POST['name']) ? trim($_POST['name']) : '';
    $email = isset($_POST['email']) ? trim($_POST['email']) : '';
    $subject = isset($_POST['subject']) ? trim($_POST['subject']) : '';
    $message = isset($_POST['message']) ? trim($_POST['message']) : '';

    // Check if any field is empty
    if (empty($name) || empty($email) || empty($subject) || empty($message)) {
        echo '<div style="display: flex; justify-content: center; align-items: center; height: 100vh;">
                <div style="text-align: center; color: red;">
                    <h1>Please Fill The Field Before Submitting</h1>
                    <img src="../View/img/maintainance.gif" alt="BAD REQUEST GIF">
                </div>
              </div>';
    } else {
        try {
            // Create database connection
            $conn = new mysqli($servername, $username, $password, $dbname);

            // Check connection
            if ($conn->connect_error) {
                throw new Exception("Connection failed: " . $conn->connect_error);
            }

            // Prepare and bind
            $stmt = $conn->prepare("INSERT INTO contactus (name, email, subject, message) VALUES (?, ?, ?, ?)");
            if (!$stmt) {
                throw new Exception("Prepare statement failed: " . $conn->error);
            }
            
            $stmt->bind_param("ssss", $name, $email, $subject, $message);

            // Execute the statement
            if ($stmt->execute() === TRUE) {
                echo '<div style="display: flex; justify-content: center; align-items: center; height: 100vh;">
                        <div style="text-align: center; color: red;">
                            <h1>Thank you!! Your support is appreciated........ <a href ="../View/homepage.php">Go Back</a></h1>
                            <img src="../View/img/thankyou.gif" alt="SUCCESS GIF">
                        </div>
                      </div>';
            } else {
                throw new Exception("Execute failed: " . $stmt->error);
            }
            
            // Close statement and connection
            $stmt->close();
            $conn->close();
        } catch (Exception $e) {
            echo '<div style="display: flex; justify-content: center; align-items: center; height: 100vh;">
                    <div style="text-align: center; color: red;">
                        <h1>There is a problem with the server. Please try again later!!</h1>
                        <p>' . htmlspecialchars($e->getMessage()) . '</p>
                        <img src="../View/img/sorry.gif" alt="BAD REQUEST GIF">
                    </div>
                  </div>';
        }
    }
} else {
    echo '<div style="display: flex; justify-content: center; align-items: center; height: 100vh;">
            <div style="text-align: center; color: red;">
                <h1>There is a problem with the server. Please try again later!!</h1>
                <img src="../View/img/sorry.gif" alt="BAD REQUEST GIF">
            </div>
          </div>';
}
?>
