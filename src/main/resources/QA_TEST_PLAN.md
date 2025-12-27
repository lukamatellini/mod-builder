# Mod QA Test Plan: Enhanced Lava

**Mod ID:** `enhancedlava`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-27T17:25:59.169Z
**Total Tests:** 21

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p enhancedlava:raw_lava_shard
/give @p enhancedlava:lava_crystal
/give @p enhancedlava:ignited_lava_shard
/give @p enhancedlava:volcanic_pickaxe
/give @p enhancedlava:volcanic_sword
/give @p enhancedlava:lava_infused_apple
/give @p enhancedlava:crystal_shard
/give @p enhancedlava:hardened_lava_block
```

## Items

### 🤖 Raw Lava Shard Registration

**Command:** `/give @p enhancedlava:raw_lava_shard`

**Steps:**
1. Run: /give @p enhancedlava:raw_lava_shard
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Lava Crystal Registration

**Command:** `/give @p enhancedlava:lava_crystal`

**Steps:**
1. Run: /give @p enhancedlava:lava_crystal
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Ignited Lava Shard Registration

**Command:** `/give @p enhancedlava:ignited_lava_shard`

**Steps:**
1. Run: /give @p enhancedlava:ignited_lava_shard
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Volcanic Pickaxe Registration

**Command:** `/give @p enhancedlava:volcanic_pickaxe`

**Steps:**
1. Run: /give @p enhancedlava:volcanic_pickaxe
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Volcanic Sword Registration

**Command:** `/give @p enhancedlava:volcanic_sword`

**Steps:**
1. Run: /give @p enhancedlava:volcanic_sword
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Lava Infused Apple Registration

**Command:** `/give @p enhancedlava:lava_infused_apple`

**Steps:**
1. Run: /give @p enhancedlava:lava_infused_apple
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Crystal Shard Registration

**Command:** `/give @p enhancedlava:crystal_shard`

**Steps:**
1. Run: /give @p enhancedlava:crystal_shard
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Hardened Lava Block Registration

**Command:** `/give @p enhancedlava:hardened_lava_block`

**Steps:**
1. Run: /give @p enhancedlava:hardened_lava_block
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Raw Lava Shard Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:magma_cream","enhancedlava:crystal_shard"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Raw Lava Shard

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Lava Crystal Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:magma_cream","enhancedlava:crystal_shard"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Lava Crystal

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Ignited Lava Shard Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["enhancedlava:raw_lava_shard"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Ignited Lava Shard

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Volcanic Pickaxe Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:magma_cream","enhancedlava:hardened_lava_block","enhancedlava:lava_crystal"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Volcanic Pickaxe

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Volcanic Sword Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:magma_cream","enhancedlava:hardened_lava_block"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Volcanic Sword

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Lava Infused Apple Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:magma_cream","enhancedlava:ignited_lava_shard"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Lava Infused Apple

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Hardened Lava Block Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:magma_cream","minecraft:iron_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Hardened Lava Block

- [ ] PASS
- [ ] FAIL: _________________

## Item Effects

### 👤 Volcanic Sword on_hit Effect

**Steps:**
1. Give yourself the item: /give @p enhancedlava:volcanic_sword
2. Hit a mob with the item
3. Observe minecraft:fire_resistance activation

**Expected:** minecraft:fire_resistance activates correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Lava Infused Apple passive Effect

**Steps:**
1. Give yourself the item: /give @p enhancedlava:lava_infused_apple
2. Hold item and wait
3. Observe minecraft:fire_resistance activation

**Expected:** minecraft:fire_resistance activates correctly

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Volcanic Core Placement

**Command:** `/give @p enhancedlava:volcanic_core`

**Steps:**
1. Run: /give @p enhancedlava:volcanic_core
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Hardened Lava Block Placement

**Command:** `/give @p enhancedlava:hardened_lava_block`

**Steps:**
1. Run: /give @p enhancedlava:hardened_lava_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Lava Crystal Ore Placement

**Command:** `/give @p enhancedlava:lava_crystal_ore`

**Steps:**
1. Run: /give @p enhancedlava:lava_crystal_ore
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Enhanced Lava Placement

**Command:** `/give @p enhancedlava:lava_block`

**Steps:**
1. Run: /give @p enhancedlava:lava_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 8 | [ ] | [ ] |
| Recipes | 7 | [ ] | [ ] |
| Item Effects | 2 | [ ] | [ ] |
| Blocks | 4 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_