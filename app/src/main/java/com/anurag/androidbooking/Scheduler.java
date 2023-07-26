package com.anurag.androidbooking;

public class Scheduler {
    long maxPeopleLimit;
    long eachSlotTime;
    long personPerSlot;

    public long getMaxPeopleLimit() {
        return maxPeopleLimit;
    }

    public void setMaxPeopleLimit(int maxPeopleLimit) {
        this.maxPeopleLimit = maxPeopleLimit;
    }

    public long getEachSlotTime() {
        return eachSlotTime;
    }

    public void setEachSlotTime(int eachSlotTime) {
        this.eachSlotTime = eachSlotTime;
    }

    public long getPersonPerSlot() {
        return personPerSlot;
    }

    public void setPersonPerSlot(int personPerSlot) {
        this.personPerSlot = personPerSlot;
    }

}
