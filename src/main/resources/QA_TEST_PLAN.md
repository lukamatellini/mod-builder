# Mod QA Test Plan: Stormforged Sky

**Mod ID:** `stormforgedsky`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-27T20:48:55.383Z
**Total Tests:** 15

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p stormforgedsky:storm_wand
/give @p stormforgedsky:heavenly_orb
/give @p stormforgedsky:storm_essence
/summon stormforgedsky:sky_watcher
```

## Items

### 🤖 Storm Wand Registration

**Command:** `/give @p stormforgedsky:storm_wand`

**Steps:**
1. Run: /give @p stormforgedsky:storm_wand
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Heavenly Orb Registration

**Command:** `/give @p stormforgedsky:heavenly_orb`

**Steps:**
1. Run: /give @p stormforgedsky:heavenly_orb
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Storm Essence Registration

**Command:** `/give @p stormforgedsky:storm_essence`

**Steps:**
1. Run: /give @p stormforgedsky:storm_essence
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Storm Wand Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:prismarine_crystals","minecraft:prismarine_crystals"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Storm Wand

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Heavenly Orb Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:prismarine_crystals","stormforgedsky:storm_essence"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Heavenly Orb

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Glowing Cobblestone Placement

**Command:** `/give @p stormforgedsky:glowing_cobblestone`

**Steps:**
1. Run: /give @p stormforgedsky:glowing_cobblestone
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Mobs

### 🤖 Sky Watcher Spawn

**Command:** `/summon stormforgedsky:sky_watcher`

**Steps:**
1. Run: /summon stormforgedsky:sky_watcher
2. Verify mob spawns without crash
3. Check mob texture is not purple/black
4. Verify mob has expected health

**Expected:** Mob spawns with correct model and attributes

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Sky Watcher AI Behavior

**Steps:**
1. Summon mob: /summon stormforgedsky:sky_watcher
2. Approach mob (should attack)
3. Observe movement patterns
4. Check mob responds to player presence

**Expected:** Mob attacks player on sight

- [ ] PASS
- [ ] FAIL: _________________

## Mob Drops

### 👤 Sky Watcher Loot

**Steps:**
1. Summon mob: /summon stormforgedsky:sky_watcher
2. Kill the mob (use /kill if needed)
3. Collect dropped items
4. Verify drops match expected loot table

**Expected:** Drops: stormforgedsky:heavenly_orb

- [ ] PASS
- [ ] FAIL: _________________

## Quests

### 👤 Orb Retrieval Activation

**Steps:**
1. Check quest is visible in quest log/journal
2. Accept quest if required
3. Verify objectives display correctly

**Expected:** Quest appears and objectives are trackable

- [ ] PASS
- [ ] FAIL: _________________

## Quest Objectives

### 👤 Orb Retrieval Objective 1

**Steps:**
1. Complete objective: collect_item storm_wand
2. Verify progress updates
3. Check completion state

**Expected:** Objective can be completed and tracks correctly

- [ ] PASS
- [ ] FAIL: _________________

## Quest Rewards

### 👤 Orb Retrieval Completion

**Steps:**
1. Complete all quest objectives
2. Turn in quest if required
3. Verify rewards are granted

**Expected:** Receive: stormforgedsky:storm_wand

- [ ] PASS
- [ ] FAIL: _________________

## Structures

### 👤 Sky Ruins Location

**Command:** `/locate structure stormforgedsky:sky_ruins`

**Steps:**
1. Run: /locate structure stormforgedsky:sky_ruins
2. Teleport to structure
3. Verify structure generated correctly

**Expected:** Structure can be located and renders correctly

- [ ] PASS
- [ ] FAIL: _________________

## Structure Loot

### 👤 Sky Ruins Chest Loot

**Steps:**
1. Locate structure
2. Find loot chests
3. Open chests
4. Verify loot is generated

**Expected:** Chests contain expected loot

- [ ] PASS
- [ ] FAIL: _________________

## Structure Spawners

### 👤 Sky Ruins Spawners

**Steps:**
1. Locate structure
2. Find spawner blocks
3. Wait for mobs to spawn
4. Verify correct mob type spawns

**Expected:** Spawners activate and spawn correct mobs

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 3 | [ ] | [ ] |
| Recipes | 2 | [ ] | [ ] |
| Blocks | 1 | [ ] | [ ] |
| Mobs | 2 | [ ] | [ ] |
| Mob Drops | 1 | [ ] | [ ] |
| Quests | 1 | [ ] | [ ] |
| Quest Objectives | 1 | [ ] | [ ] |
| Quest Rewards | 1 | [ ] | [ ] |
| Structures | 1 | [ ] | [ ] |
| Structure Loot | 1 | [ ] | [ ] |
| Structure Spawners | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_