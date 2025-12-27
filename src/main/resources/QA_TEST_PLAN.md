# Mod QA Test Plan: Ethereal Expanse

**Mod ID:** `etherealexpanse`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-27T16:00:42.014Z
**Total Tests:** 23

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p etherealexpanse:ethereal_crystal
/give @p etherealexpanse:void_compass
/give @p etherealexpanse:anchor_boots
/give @p etherealexpanse:void_expanse_portal_igniter
/summon etherealexpanse:void_glider
/execute in etherealexpanse:void_expanse run tp @p ~ 100 ~
```

## Items

### 🤖 Ethereal Crystal Registration

**Command:** `/give @p etherealexpanse:ethereal_crystal`

**Steps:**
1. Run: /give @p etherealexpanse:ethereal_crystal
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Void Compass Registration

**Command:** `/give @p etherealexpanse:void_compass`

**Steps:**
1. Run: /give @p etherealexpanse:void_compass
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Anchor Boots Registration

**Command:** `/give @p etherealexpanse:anchor_boots`

**Steps:**
1. Run: /give @p etherealexpanse:anchor_boots
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Void Expanse Portal Key Registration

**Command:** `/give @p etherealexpanse:void_expanse_portal_igniter`

**Steps:**
1. Run: /give @p etherealexpanse:void_expanse_portal_igniter
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Ethereal Crystal Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:coal"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Ethereal Crystal

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Compass Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:coal","etherealexpanse:ethereal_crystal"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Void Compass

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Anchor Boots Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["etherealexpanse:ethereal_crystal"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Anchor Boots

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Expanse Portal Key Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:coal","minecraft:coal","minecraft:coal"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Void Expanse Portal Key

- [ ] PASS
- [ ] FAIL: _________________

## Item Effects

### 👤 Void Compass passive Effect

**Steps:**
1. Give yourself the item: /give @p etherealexpanse:void_compass
2. Hold item and wait
3. Observe minecraft:glowing activation

**Expected:** minecraft:glowing activates correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Anchor Boots passive Effect

**Steps:**
1. Give yourself the item: /give @p etherealexpanse:anchor_boots
2. Hold item and wait
3. Observe minecraft:glowing activation

**Expected:** minecraft:glowing activates correctly

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Voidstone Placement

**Command:** `/give @p etherealexpanse:voidstone`

**Steps:**
1. Run: /give @p etherealexpanse:voidstone
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Ethereal Crystal Ore Placement

**Command:** `/give @p etherealexpanse:ethereal_crystal_ore`

**Steps:**
1. Run: /give @p etherealexpanse:ethereal_crystal_ore
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Gravity Anchor Placement

**Command:** `/give @p etherealexpanse:gravity_anchor`

**Steps:**
1. Run: /give @p etherealexpanse:gravity_anchor
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Mobs

### 🤖 Void Glider Spawn

**Command:** `/summon etherealexpanse:void_glider`

**Steps:**
1. Run: /summon etherealexpanse:void_glider
2. Verify mob spawns without crash
3. Check mob texture is not purple/black
4. Verify mob has expected health

**Expected:** Mob spawns with correct model and attributes

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Glider AI Behavior

**Steps:**
1. Summon mob: /summon etherealexpanse:void_glider
2. Approach mob (should be passive)
3. Observe movement patterns
4. Check mob responds to player presence

**Expected:** Mob ignores or flees from player

- [ ] PASS
- [ ] FAIL: _________________

## Mob Drops

### 👤 Void Glider Loot

**Steps:**
1. Summon mob: /summon etherealexpanse:void_glider
2. Kill the mob (use /kill if needed)
3. Collect dropped items
4. Verify drops match expected loot table

**Expected:** Drops: ethereal_crystal

- [ ] PASS
- [ ] FAIL: _________________

## Dimensions

### 👤 Void Expanse Portal Entry

**Steps:**
1. Build or activate dimension portal
2. Enter portal
3. Verify teleport to dimension
4. Check dimension generates correctly

**Expected:** Successfully enter dimension without crash

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Expanse World Generation

**Command:** `/execute in etherealexpanse:void_expanse run tp @p ~ 100 ~`

**Steps:**
1. Teleport: /execute in etherealexpanse:void_expanse run tp @p ~ 100 ~
2. Explore dimension terrain
3. Verify expected biomes/features
4. Check lighting and sky render correctly

**Expected:** Dimension terrain generates with expected features

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Expanse Return Portal

**Steps:**
1. While in dimension, activate return portal
2. Enter portal
3. Verify return to overworld

**Expected:** Successfully return from dimension

- [ ] PASS
- [ ] FAIL: _________________

## Biomes

### 👤 Void Expanse Biome Generation

**Command:** `/locatebiome etherealexpanse:void_expanse_biome`

**Steps:**
1. Run: /locatebiome etherealexpanse:void_expanse_biome
2. Teleport to biome location
3. Verify biome features are present
4. Check mob spawns are correct

**Expected:** Biome generates with expected features and spawns

- [ ] PASS
- [ ] FAIL: _________________

## Structures

### 👤 Void Expanse Obelisk Location

**Command:** `/locate structure etherealexpanse:void_expanse_structure`

**Steps:**
1. Run: /locate structure etherealexpanse:void_expanse_structure
2. Teleport to structure
3. Verify structure generated correctly

**Expected:** Structure can be located and renders correctly

- [ ] PASS
- [ ] FAIL: _________________

## Structure Loot

### 👤 Void Expanse Obelisk Chest Loot

**Steps:**
1. Locate structure
2. Find loot chests
3. Open chests
4. Verify loot is generated

**Expected:** Chests contain expected loot

- [ ] PASS
- [ ] FAIL: _________________

## Structure Spawners

### 👤 Void Expanse Obelisk Spawners

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
| Items | 4 | [ ] | [ ] |
| Recipes | 4 | [ ] | [ ] |
| Item Effects | 2 | [ ] | [ ] |
| Blocks | 3 | [ ] | [ ] |
| Mobs | 2 | [ ] | [ ] |
| Mob Drops | 1 | [ ] | [ ] |
| Dimensions | 3 | [ ] | [ ] |
| Biomes | 1 | [ ] | [ ] |
| Structures | 1 | [ ] | [ ] |
| Structure Loot | 1 | [ ] | [ ] |
| Structure Spawners | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_