import example1.PaulsSmartHomeControl
import example1.attempts.SmartHomeControlAttempt2


def atMorning(controls: PaulsSmartHomeControl): Unit = {
  controls.turnOnFireplace

  //OH NO! There's a fire!

  var awake = false
  while(!awake){
    awake = controls.wakeupCall
  }

  controls.turnOnSprinklers
}

atMorning(SmartHomeControlAttempt2)

SmartHomeControlAttempt2.whatHappened