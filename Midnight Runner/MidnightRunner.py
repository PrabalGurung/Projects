import pygame
from sys import exit
from random import randint, choice

class Player(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        # importing image
        player_idle1 = pygame.image.load('Graphic/Character/Idle/CyberPunk_Idle1.png').convert_alpha()
        player_idle2 = pygame.image.load('Graphic/Character/Idle/CyberPunk_Idle2.png').convert_alpha()
        
        player_walk1 = pygame.image.load('Graphic/Character/Walk/CyberPunk_Blonde_Walk1.png').convert_alpha()
        player_walk2 = pygame.image.load('Graphic/Character/Walk/CyberPunk_Blonde_Walk2.png').convert_alpha()
        player_walk3 = pygame.image.load('Graphic/Character/Walk/CyberPunk_Blonde_Walk3.png').convert_alpha()
        player_walk4 = pygame.image.load('Graphic/Character/Walk/CyberPunk_Blonde_Walk4.png').convert_alpha()
        
        player_jump1 = pygame.image.load('Graphic/Character/Jump/CyberPunk_Jump1.png').convert_alpha()
        player_jump2 = pygame.image.load('Graphic/Character/Jump/CyberPunk_Jump2.png').convert_alpha()
        player_jump3 = pygame.image.load('Graphic/Character/Jump/CyberPunk_Jump3.png').convert_alpha()
        player_jump4 = pygame.image.load('Graphic/Character/Jump/CyberPunk_Jump4.png').convert_alpha()
        
        self.player_jump_sound = pygame.mixer.Sound('Sound/Jump/jump.mp3')
        
        # creating tuple for a smooth animation
        self.player_idle = [player_idle1, player_idle2]
        self.player_walk = [player_walk1, player_walk2, player_walk3, player_walk4]
        self.player_jump = [player_jump1, player_jump2, player_jump3, player_jump4]
        
        self.player_index = 0 # this helps in keeping track of animation
        self.gravity = 0 # this helps in player jump physics
        
        self.image = self.player_walk[self.player_index]
        self.rect = self.image.get_rect(midbottom = (50,300))
        
    # this function helps in jump animation and sound
    def player_input(self):
        keys = pygame.key.get_pressed()
        if keys[pygame.K_SPACE] and self.rect.bottom >= 300:
            self.player_jump_sound.play()
            self.player_jump_sound.set_volume(0.3)
            self.gravity = -15
    
    # this applies the physics of jump in game
    def apply_gravity(self):
        self.gravity += 1
        self.rect.y += self.gravity
        if self.rect.bottom >= 300:
            self.rect.bottom = 300

    # this checks whether the player is having jumping animation or running animation
    def player_animation_state(self):
        if self.rect.bottom < 300:
            self.player_index += 0.1
            if self.player_index >= len(self.player_jump): self.player_index = 0
            self.image = self.player_jump[int(self.player_index)]
        else:
            self.player_index += 0.1
            if self.player_index >= len(self.player_walk): self.player_index = 0
            self.image = self.player_walk[int(self.player_index)]

    # this function updates all values in game
    def update(self):
        self.player_input()
        self.apply_gravity()
        self.player_animation_state()
        
class Obstacle(pygame.sprite.Sprite):
    def __init__(self,type):
        super().__init__()
        # when the class is called it checks whether bird is being animated or duck
        if type == 'Bird':
            bird1 = pygame.image.load('Graphic/Monster/Bats/batwalk1.png').convert_alpha()
            bird2 = pygame.image.load('Graphic/Monster/Bats/batwalk2.png').convert_alpha()
            bird3 = pygame.image.load('Graphic/Monster/Bats/batwalk3.png').convert_alpha()

            self.frame = [bird1, bird2, bird3]
            y_pos = 210
        else:
            duck1 = pygame.image.load('Graphic/Monster/Duck/Walk/walk1.png').convert_alpha()
            duck2 = pygame.image.load('Graphic/Monster/Duck/Walk/walk2.png').convert_alpha()
            duck3 = pygame.image.load('Graphic/Monster/Duck/Walk/walk3.png').convert_alpha()
            duck4 = pygame.image.load('Graphic/Monster/Duck/Walk/walk4.png').convert_alpha()
            self.frame = [duck1, duck2, duck3, duck4]
            y_pos = 300
        
        self.animaton_index = 0
        self.image = self.frame [self.animaton_index]
        self.rect = self.image.get_rect(midbottom = (randint(900,1100), y_pos))

    # this function animates the mobs 
    def animation_state(self):
        self.animaton_index += 0.1
        if self.animaton_index >= len(self.frame): self.animaton_index = 0
        self.image = self.frame[int(self.animaton_index)]

    # this function destroys the mobs after certain time in frame
    def destroy(self):
        if self.rect.x <= -100: self.kill()
                
    # thisfunction gives update of mobs
    def update(self):
        self.animation_state()
        self.rect.x -= 10
        self.destroy()
             
# this function checks whether the player has collided with player frames or not
def collision_sprite():
    if pygame.sprite.spritecollide(player.sprite, obstacle, False):
        obstacle.empty()
        return False
    else:
        return True
             
# this function checks the time game has been played and keeps score in second time
def display_score():
    current_time = pygame.time.get_ticks() - start_time
    score_surf = test_font.render(f'Score: {int(current_time/1000)}', False, (64,64,64))
    score_rect = score_surf.get_rect(center = (300,50))
    screen.blit(score_surf, score_rect)
    return int (current_time/1000)

# declaring pygame
pygame.init()
screen = pygame.display.set_mode((600,400)) #declaring height and width of screen
pygame.display.set_caption("Midnight Runner") #declaring name of screen
clock = pygame.time.Clock() #calling Clock function from pygame

# setting necessary variables
game_active = False
start_time = 0
score = 0

# calling backgrounds
background1 = pygame.image.load('Graphic/Background/City_Backround_Layer1.png')
background2 = pygame.image.load('Graphic/Background/City_Backround_Layer2.png')
background3 = pygame.image.load('Graphic/Background/City_Backround_Layer3.png')
background4 = pygame.image.load('Graphic/Background/City_Backround_Layer4.png')
background5 = pygame.image.load('Graphic/Background/City_Backround_Layer5.png')
background6 = pygame.image.load('Graphic/Background/City_Backround_Layer6.png')
background7 = pygame.image.load('Graphic/Background/City_Backround_Layer7.png')
background8 = pygame.image.load('Graphic/Background/City_Backround_Layer8.png')
background9 = pygame.image.load('Graphic/Background/City_Backround_Layer9.png')
surface1 = pygame.image.load('Graphic/Background/bottom_surface.png')

# calling font
test_font = pygame.font.Font('Font/Pixel.ttf', 50)

# setting names and text for game
midnight_runner = test_font.render('Midnight Runner', False, 'White')
midnight_runner_rect = midnight_runner.get_rect(center = (300, 100))

game_message = test_font.render('Press space to run', False, 'White')
game_message_rect = game_message.get_rect(center = (300, 300))

# setting music
death_music = pygame.mixer.Sound('Sound/Death/Death.mp3')
title_music = pygame.mixer.Sound('Sound/Title_Music/title.mp3')

# 
obstacle_timer = pygame.USEREVENT + 1
pygame.time.set_timer(obstacle_timer, 1500)

# player groupSingle
player = pygame.sprite.GroupSingle()
player.add(Player())

# obstacle group
obstacle = pygame.sprite.Group()

# main code that runs until quit
while True:
    for event in pygame.event.get():
        # close program
        if event.type == pygame.QUIT:
            pygame.quit()
            exit()
        if game_active:
            # event in game which spawns mob randomly
            if event.type == obstacle_timer:
                obstacle.add(Obstacle(choice(['Bird','Duck','Duck'])))
        else:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                game_active = True
                start_time = pygame.time.get_ticks()
    if game_active: # this is the game phase
        # prints background in screen
        screen.blit(background9,(0,0))
        screen.blit(background8,(0,0))
        screen.blit(background7,(0,0))
        screen.blit(background6,(0,0))
        screen.blit(background5,(0,0))
        screen.blit(background4,(0,0))
        screen.blit(background3,(0,0))
        screen.blit(background2,(0,0))
        screen.blit(background1,(0,0))    
        screen.blit(surface1,(0,300))
        
        #player group
        player.draw(screen)
        player.update()

        # obstacle group
        obstacle.draw(screen)
        obstacle.update()
        
        # score
        score = display_score()
        
        # collision
        game_active = collision_sprite()
        
        # if player dies plays the following music
        if game_active == False:
            death_music.play()   
    else: # this is title screen
        screen.fill('Black')    
        player_gravity = 0
        score_message = test_font.render(f'Your Score: {score}', False, ('White'))
        score_message_rect = score_message.get_rect(center = (300, 300))
        screen.blit(midnight_runner, midnight_runner_rect)
        player_gravity = 0
        
        # checks the appropriate message to show
        if score == 0:
            screen.blit(game_message, game_message_rect)
        else:
            screen.blit(score_message, score_message_rect)
    
    # title screen music
    if game_active:
        title_music.stop()
    else:
        title_music.play()

    pygame.display.update()
    clock.tick(60)

            
        