import numpy as np
import speech_recognition as sr
import sounddevice as sd
import scipy.io.wavfile as wavfile
import subprocess
import sys
import os
import time

# ========== CONFIGURATION ==========
SAMPLE_RATE = 16000
RECORD_SECONDS = 4
TEMP_WAV_PATH = "temp_input.wav"
SILENCE_THRESHOLD = 500  


def speak(text: str):
    subprocess.call(["say", text])

def record_to_file(duration: float = RECORD_SECONDS):
    """
    Record `duration` seconds, write to WAV, and return (np_array, filepath).
    """
    print(f"[recording {duration} seconds...]")
    recording = sd.rec(
        int(duration * SAMPLE_RATE), samplerate=SAMPLE_RATE, channels=1, dtype="int16"
    )
    sd.wait()
    wavfile.write(TEMP_WAV_PATH, SAMPLE_RATE, recording)
    return recording.flatten(), TEMP_WAV_PATH

def listen_command() -> str:
    """
    Record, check for silence, then run through SpeechRecognition.
    """
    audio_data, wav_path = record_to_file()
    # If below threshold → treat as silence, return ""
    if np.max(np.abs(audio_data)) < SILENCE_THRESHOLD:
        os.remove(wav_path)
        return ""

    recognizer = sr.Recognizer()
    try:
        with sr.AudioFile(wav_path) as source:
            audio = recognizer.record(source)
        text = recognizer.recognize_google(audio).lower()
        print(f"[Recognized] {text}")
        return text
    except sr.UnknownValueError:
        # only trigger when there was speech but unrecognized
        speak("Sorry, I did not catch that.")
        return ""
    except sr.RequestError:
        speak("Speech service unavailable.")
        return ""
    finally:
        if os.path.exists(wav_path):
            os.remove(wav_path)

# ======== COMMAND IMPLEMENTATIONS ========

def open_chrome():
    subprocess.call(["open", "-a", "Google Chrome"])
    speak("Opening Chrome")

def new_tab():
    applescript = '''
    tell application "Google Chrome"
        activate
        tell window 1 to make new tab
    end tell
    '''
    subprocess.call(["osascript", "-e", applescript])
    speak("New tab opened")

def sleep_system():
    subprocess.call(["pmset", "sleepnow"])
    # no speak, system sleeps immediately

def close_application(app_name: str = "Google Chrome"):
    applescript = f'''
    tell application "{app_name}"
        quit
    end tell
    '''
    subprocess.call(["osascript", "-e", applescript])
    speak(f"Closing {app_name}")

def play_music():
    applescript = '''
    tell application "Music"
        activate
        play
    end tell
    '''
    subprocess.call(["osascript", "-e", applescript])
    speak("Playing music")

def toggle_play_pause():
    """
    Spacebar toggles play/pause for YouTube in Chrome.
    """
    applescript = '''
    tell application "Google Chrome" to activate
    tell application "System Events"
        keystroke " "
    end tell
    '''
    subprocess.call(["osascript", "-e", applescript])
    speak("Toggling video")

def increase_volume():
    """
    Up arrow in YouTube increases volume.
    """
    applescript = '''
    tell application "Google Chrome" to activate
    tell application "System Events"
        key code 126
    end tell
    '''
    subprocess.call(["osascript", "-e", applescript])
    speak("Volume increased")

def decrease_volume():
    """
    Down arrow in YouTube decreases volume.
    """
    applescript = '''
    tell application "Google Chrome" to activate
    tell application "System Events"
        key code 125
    end tell
    '''
    subprocess.call(["osascript", "-e", applescript])
    speak("Volume decreased")

# ======== DISPATCHER ========

def handle_command(cmd: str):
    if "open chrome" in cmd:
        open_chrome()
    elif "new tab" in cmd:
        new_tab()
    elif "sleep" in cmd:
        sleep_system()
    elif "close chrome" in cmd or "close application" in cmd:
        close_application("Google Chrome")
    elif "play music" in cmd:
        play_music()
    elif "stop it" in cmd or "pause video" in cmd:
        toggle_play_pause()
    elif "resume" in cmd or "play video" in cmd:
        toggle_play_pause()
    elif "increase sound" in cmd or "increase volume" in cmd:
        increase_volume()
    elif "decrease sound" in cmd or "decrease volume" in cmd:
        decrease_volume()
    else:
        speak("Command not recognized.")

def main():
    speak("Fuck off you son of a bitch, i will not do you work")
    time.sleep(0.5)
    while True:
        command = listen_command()
        if not command:
            continue

        if "exit agent" in command or "stop listening" in command:
            speak("Shutting down.")
            sys.exit(0)

        handle_command(command)

if __name__ == "__main__":
    main()
