# Mod QA Test Plan: Voidborne Expanse

**Mod ID:** `voidborneexpanse`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-27T16:17:02.366Z
**Total Tests:** 32

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p voidborneexpanse:ethereal_crystal
/give @p voidborneexpanse:gravity_core
/give @p voidborneexpanse:void_shard
/give @p voidborneexpanse:weightless_boots
/give @p voidborneexpanse:ethereal_pickaxe
/give @p voidborneexpanse:gravity_manipulator
/give @p voidborneexpanse:void_expanse_portal_igniter
/give @p voidborneexpanse:ethereal_crystal_ore
/execute in voidborneexpanse:void_expanse run tp @p ~ 100 ~
```

## Items

### 🤖 Ethereal Crystal Registration

**Command:** `/give @p voidborneexpanse:ethereal_crystal`

**Steps:**
1. Run: /give @p voidborneexpanse:ethereal_crystal
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Gravity Core Registration

**Command:** `/give @p voidborneexpanse:gravity_core`

**Steps:**
1. Run: /give @p voidborneexpanse:gravity_core
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Void Shard Registration

**Command:** `/give @p voidborneexpanse:void_shard`

**Steps:**
1. Run: /give @p voidborneexpanse:void_shard
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Weightless Boots Registration

**Command:** `/give @p voidborneexpanse:weightless_boots`

**Steps:**
1. Run: /give @p voidborneexpanse:weightless_boots
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Ethereal Pickaxe Registration

**Command:** `/give @p voidborneexpanse:ethereal_pickaxe`

**Steps:**
1. Run: /give @p voidborneexpanse:ethereal_pickaxe
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Gravity Manipulator Registration

**Command:** `/give @p voidborneexpanse:gravity_manipulator`

**Steps:**
1. Run: /give @p voidborneexpanse:gravity_manipulator
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Void Expanse Portal Key Registration

**Command:** `/give @p voidborneexpanse:void_expanse_portal_igniter`

**Steps:**
1. Run: /give @p voidborneexpanse:void_expanse_portal_igniter
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Ethereal Crystal Ore Registration

**Command:** `/give @p voidborneexpanse:ethereal_crystal_ore`

**Steps:**
1. Run: /give @p voidborneexpanse:ethereal_crystal_ore
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
2. Arrange ingredients: ["voidborneexpanse:ethereal_crystal_ore"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Ethereal Crystal

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Gravity Core Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:coal","minecraft:coal"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Gravity Core

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Shard Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:coal","minecraft:coal"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Void Shard

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Weightless Boots Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["voidborneexpanse:ethereal_crystal","voidborneexpanse:void_shard"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Weightless Boots

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Ethereal Pickaxe Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:coal","voidborneexpanse:ethereal_crystal","voidborneexpanse:void_shard"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Ethereal Pickaxe

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Gravity Manipulator Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["voidborneexpanse:void_shard","voidborneexpanse:ethereal_crystal","voidborneexpanse:gravity_core"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Gravity Manipulator

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

### 👤 Ethereal Crystal Ore Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:coal","minecraft:iron_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Ethereal Crystal Ore

- [ ] PASS
- [ ] FAIL: _________________

## Item Effects

### 👤 Weightless Boots passive Effect

**Steps:**
1. Give yourself the item: /give @p voidborneexpanse:weightless_boots
2. Hold item and wait
3. Observe minecraft:glowing activation

**Expected:** minecraft:glowing activates correctly

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Voidstone Placement

**Command:** `/give @p voidborneexpanse:voidstone`

**Steps:**
1. Run: /give @p voidborneexpanse:voidstone
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Ethereal Crystal Ore Placement

**Command:** `/give @p voidborneexpanse:ethereal_crystal_ore`

**Steps:**
1. Run: /give @p voidborneexpanse:ethereal_crystal_ore
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Gravity Anchor Block Placement

**Command:** `/give @p voidborneexpanse:gravity_anchor_block`

**Steps:**
1. Run: /give @p voidborneexpanse:gravity_anchor_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Weightless Grass Block Placement

**Command:** `/give @p voidborneexpanse:weightless_grass_block`

**Steps:**
1. Run: /give @p voidborneexpanse:weightless_grass_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Shroom Placement

**Command:** `/give @p voidborneexpanse:void_shroom`

**Steps:**
1. Run: /give @p voidborneexpanse:void_shroom
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Ethereal Wood Log Placement

**Command:** `/give @p voidborneexpanse:ethereal_wood_log`

**Steps:**
1. Run: /give @p voidborneexpanse:ethereal_wood_log
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

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

**Command:** `/execute in voidborneexpanse:void_expanse run tp @p ~ 100 ~`

**Steps:**
1. Teleport: /execute in voidborneexpanse:void_expanse run tp @p ~ 100 ~
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

**Command:** `/locatebiome voidborneexpanse:void_expanse_biome`

**Steps:**
1. Run: /locatebiome voidborneexpanse:void_expanse_biome
2. Teleport to biome location
3. Verify biome features are present
4. Check mob spawns are correct

**Expected:** Biome generates with expected features and spawns

- [ ] PASS
- [ ] FAIL: _________________

## Structures

### 👤 Void Spire Location

**Command:** `/locate structure voidborneexpanse:void_spire`

**Steps:**
1. Run: /locate structure voidborneexpanse:void_spire
2. Teleport to structure
3. Verify structure generated correctly

**Expected:** Structure can be located and renders correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Void Expanse Obelisk Location

**Command:** `/locate structure voidborneexpanse:void_expanse_structure`

**Steps:**
1. Run: /locate structure voidborneexpanse:void_expanse_structure
2. Teleport to structure
3. Verify structure generated correctly

**Expected:** Structure can be located and renders correctly

- [ ] PASS
- [ ] FAIL: _________________

## Structure Loot

### 👤 Void Spire Chest Loot

**Steps:**
1. Locate structure
2. Find loot chests
3. Open chests
4. Verify loot is generated

**Expected:** Chests contain expected loot

- [ ] PASS
- [ ] FAIL: _________________

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
| Items | 8 | [ ] | [ ] |
| Recipes | 8 | [ ] | [ ] |
| Item Effects | 1 | [ ] | [ ] |
| Blocks | 6 | [ ] | [ ] |
| Dimensions | 3 | [ ] | [ ] |
| Biomes | 1 | [ ] | [ ] |
| Structures | 2 | [ ] | [ ] |
| Structure Loot | 2 | [ ] | [ ] |
| Structure Spawners | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_