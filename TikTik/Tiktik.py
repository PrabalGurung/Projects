import pygame
from sys import exit

# initiating pygame
pygame.init()
screen = pygame.display.set_mode((1000,500))
pygame.display.set_caption("TikTik")
clock = pygame.time.Clock()

# initializing necessary variables
game_active = False
pressed_w = False
pressed_s = False
pressed_i = False
pressed_k = False
ball_x_movement = True
ball_y_movement = True
player1_y_pos = 200
player1_x_pos = 50
player2_y_pos = 200
player2_x_pos = 900
ball_pos_x = 500
ball_pos_y = 250
winner = 0

# setting font
pixel_font = pygame.font.Font('Font/Pixel.ttf', 50)

# make font
TikTik = pixel_font.render('TikTik', False, 'White')
TikTik_rect = TikTik.get_rect(center = (500,100))
play_message = pixel_font.render('Press Space For Multiplayer', False, 'White')
play_message_rect = play_message.get_rect(center = (500,400))

# initializing sound
sound = pygame.mixer.Sound('Sound/blip.mp3')

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit()
        # checks the condition of the game
        if game_active:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                game_active = False
        else:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                game_active = True
                ball_pos_x = 500
                ball_pos_y = 225
                winner = 0
        # checks the user inputs
        if event.type == pygame.KEYDOWN and event.key  == pygame.K_w:
            pressed_s = False
            pressed_w = True
        if event.type == pygame.KEYDOWN and event.key == pygame.K_s:
            pressed_w = False
            pressed_s = True
        if event.type == pygame.KEYDOWN and event.key  == pygame.K_i:
            pressed_i = True
            pressed_k = False
        if event.type == pygame.KEYDOWN and event.key == pygame.K_k:
            pressed_k = True
            pressed_i = False
    # checks the button pressed and runs necessary line
    if game_active:        
        if pressed_w:
            player1_y_pos -= 7
            
        if pressed_s:
            player1_y_pos += 7
            
        if pressed_i:
            player2_y_pos -= 7
            
        if pressed_k:   
            player2_y_pos += 7
        
        if player1_y_pos <= 0:
            pressed_w = False
            player1_y_pos = 0 
            
        if player1_y_pos >= 500:
            pressed_s = False
            player1_y_pos = 400
            
        if player2_y_pos <= 0:
            pressed_i = False
            player2_y_pos = 0 
            
        if player2_y_pos >= 500:
            pressed_k = False
            player2_y_pos = 400
    
    # initiates new draw
    player1_info = pygame.Rect(player1_x_pos,player1_y_pos,10,100)
    player2_info = pygame.Rect(player2_x_pos,player2_y_pos,10,100)        
    ball_info = pygame.Rect(ball_pos_x,ball_pos_y,20,20)
    
    # checks the collision
    if player1_info.colliderect(ball_info):
        sound.play()
        ball_x_movement = False
    if player2_info.colliderect(ball_info):
        sound.play()
        ball_x_movement = True
    
    # checks and moves ball accorodingly   
    if ball_pos_y >= 500:
        ball_y_movement = True
    elif ball_pos_y <= 0:
        ball_y_movement = False
        
    if ball_y_movement:
        ball_pos_y -= 7
    else:
        ball_pos_y += 7
    
    if ball_pos_x >= 1000:
        game_active = False
        winner = 1
    if ball_pos_x <= 0:
        game_active = False
        winner = 2 
       
    if ball_x_movement:
        ball_pos_x -= 6
    else:
        ball_pos_x += 6
         
    if game_active:
        # fills the screen
        screen.fill('Black')
        player1 = pygame.draw.rect(screen, "White", player1_info)
        player2 = pygame.draw.rect(screen, "White", player2_info)
        ball = pygame.draw.ellipse(screen, "White", ball_info)
    else:
        # title screen
        screen.fill('Black')
        winner_message = pixel_font.render(f'Player {winner} Wins', False, 'White')
        winner_message_rect = winner_message.get_rect(center = (500, 400))
        screen.blit(TikTik,TikTik_rect)
        if winner == 0:
            screen.blit(play_message, play_message_rect)
        else:
            screen.blit(winner_message, winner_message_rect)
        
    pygame.display.update()
    clock.tick(60)
    