<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>AquaSentinel - Hydro Project</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">
    <meta http-equiv="refresh" content="5"> <!-- Refresh every 5 seconds -->
    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500&family=Jost:wght@500;600;700&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
</head>

<body data-bs-spy="scroll" data-bs-target=".navbar" data-bs-offset="51">
    <div class="container-xxl bg-white p-0">

        <a href="homepage.php" class="position-fixed top-0 start-0 m-3 text-decoration-none" style="color: #4294E3;">
            <i class="bi bi-arrow-left"></i> Go Back
        </a>
        <br><br><br>
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <div class="container-fluid">
        <!-- Content Row -->

        <div class="row">
            <!-- Area Chart -->
            <div class="col-xl-8 col-lg-7">
                <div class="card shadow mb-4">
                
                    <!-- Card Body -->
                    <div class="card-body">
                        <h2 style="color: #4294E3;">Water Level:</h2><br>
                        <div class="chart-area">
                            <canvas id="myChart" style="width:100%;max-width:600px"></canvas>
                            <?php
                                require_once('../Controller/ArduinoLiveData.php'); // Include the ArduinoLiveData file

                                // Call the getDataFromCSV() method of the ArduinoLiveData
                                $filename = "../Data/arduinoData.csv"; // Change the file path as needed
                                $data = ArduinoLiveData::getDataFromCSV($filename);
                            ?>
                            <script>
                            const xValues = [<?php foreach($data as $farm_data) echo "'" . $farm_data->getDatetime() . "',"; ?>];
                            const yValues = [<?php foreach($data as $farm_data) echo $farm_data->getDistance() . ','; ?>];
                            
                            new Chart("myChart", {
                            type: "line",
                            data: {
                                labels: xValues,
                                datasets: [{
                                fill: false,
                                lineTension: 0,
                                backgroundColor: "rgba(0,0,255,1.0)",
                                borderColor: "rgba(0,0,255,0.1)",
                                data: yValues
                                }]
                            },
                            options: {
                                legend: {display: false},
                                scales: {
                                    yAxes: [{ticks: {min: 5, max:30}}],
                                    xAxes: [{
                                        ticks: {
                                            minRotation: 45,
                                            maxRotation: 45
                                        }   
                                    }]
                                }
                            }
                            });
                            </script>
                        </div>
                    </div>

                    
                </div>
            </div>
            <div class="col-xl-4 col-lg-5">
                <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">Dam Operate</h6>
                        <div class="dropdown no-arrow">
                            <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                aria-labelledby="dropdownMenuLink">
                                <div class="dropdown-header">Dropdown Header:</div>
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </div>
                    </div>
                    <!-- Card Body -->
                    <div class="card-body">
                    <?php
                    if (!empty($data)) {
                        echo '<table class="table">';
                        echo '<tr><th scope="col">S.No</th><th scope="col">Water Level</th></tr>';
                        // Initialize a counter variable
                        $counter = 1;
                        // Display the last five extracted data in table rows
                        foreach ($data as $farm_data) {
                            echo '<tr>';
                            // Output the counter value
                            echo '<td>' . $counter . '</td>';
                            echo '<td>' . $farm_data->getDistance() . '</td>';
                            echo '</tr>';
                            // Increment the counter
                            $counter++;
                        }
                        echo '</table>';
                    } else {
                        echo 'No data available.';
                    }
                    ?>
                    </div>
                </div>
                <p>* If the number goes down than 10 then alert system activates</p>
            </div>
</div>

<br><br>
<h2 style="color: #4294E3;">Other Features:</h2><br>
<?php
if (!empty($data)) {
    echo '<table class="table">';
    echo '<tr><th scope="col">S.No</th><th scope="col">Agriculture Pump</th><th scope="col">Water Storage</th></tr>';

    $counter = 1;
    foreach ($data as $farm_data) {
        echo '<tr>';
        echo '<td>' . $counter . '</td>';
        echo '<td>' . $farm_data->getWaterStorage() . '</td>';
        echo '<td>' . $farm_data->getAgriculturePump() . '</td>';
        echo '</tr>';
        $counter++;
    }
        echo '</table>';
    } else {
        echo 'No data available.';
    }
?>
        <!-- Footer Start -->
        <div class="container-fluid bg-primary text-light footer wow fadeIn" data-wow-delay="0.1s">
            <div class="container py-5 px-lg-5">
                <div class="row g-5">
                    <div class="col-md-6 col-lg-3">
                        <h4 class="text-white mb-4">Address</h4>
                        <p><i class="fa fa-map-marker-alt me-3"></i>Pokhara-15, Nayagaun</p>
                        <p><i class="fa fa-phone-alt me-3"></i>+977 9827145355</p>
                        <p><i class="fa fa-envelope me-3"></i>aquasentinel00@info.com</p>
                        <div class="d-flex pt-2">   
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-instagram"></i></a>
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <h4 class="text-white mb-4">Quick Link</h4>
                        <a class="btn btn-link" href="">About Us</a>
                        <a class="btn btn-link" href="">Contact Us</a>
                        <a class="btn btn-link" href="">Privacy Policy</a>
                        <a class="btn btn-link" href="">Terms & Condition</a>
                        <a class="btn btn-link" href="">Career</a>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <h4 class="text-white mb-4">Popular Link</h4>
                        <a class="btn btn-link" href="">About Us</a>
                        <a class="btn btn-link" href="">Contact Us</a>
                        <a class="btn btn-link" href="">Privacy Policy</a>
                        <a class="btn btn-link" href="">Terms & Condition</a>
                        <a class="btn btn-link" href="">Career</a>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <h4 class="text-white mb-4">Newsletter</h4>
                        <p>Revolutionizing Water Management with Automated Control for Dams, Irrigation, and Flood Prevention - Ensuring Sustainability and Safety.</p>
                        <div class="position-relative w-100 mt-3">
                            <input class="form-control border-0 rounded-pill w-100 ps-4 pe-5" type="text" placeholder="Your Email" style="height: 48px;">
                            <button type="button" class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2"><i class="fa fa-paper-plane text-primary-gradient fs-4"></i></button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container px-lg-5">
                <div class="copyright">
                    <div class="row">
                        <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                            &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved. 
							
							<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
							Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                        </div>
                        <div class="col-md-6 text-center text-md-end">
                            <div class="footer-menu">
                                <a href="">Home</a>
                                <a href="">Cookies</a>
                                <a href="">Help</a>
                                <a href="">FQAs</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-lg-square back-to-top pt-2"><i class="bi bi-arrow-up text-white"></i></a>
    </div>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>