# QA Test Plan: Lucky Loot Boxes

Generated: 2026-01-07T02:52:28.049Z
Minecraft Version: 1.21.1
Mod ID: luckylootboxes

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 54 |
| Passed | 44 |
| Failed | 5 |
| Warnings | 3 |
| Skipped | 2 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `luckylootboxes.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Charm | `/give @p luckylootboxes:lucky_charm` | ☐ | ☐ | ☐ |
| Unlucky Charm | `/give @p luckylootboxes:unlucky_charm` | ☐ | ☐ | ☐ |
| Four-Leaf Clover | `/give @p luckylootboxes:four_leaf_clover` | ☐ | ☐ | ☐ |
| Common Bone | `/give @p luckylootboxes:common_bone` | ☐ | ☐ | ☐ |
| Rare Wither Skeleton Skull | `/give @p luckylootboxes:rare_wither_skeleton_skull` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Charm

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Charm"
- [ ] Crafting recipe works

#### Unlucky Charm

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Unlucky Charm"
- [ ] Crafting recipe works

#### Four-Leaf Clover

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Four-Leaf Clover"
- [ ] Crafting recipe works

#### Common Bone

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Common Bone"

#### Rare Wither Skeleton Skull

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Rare Wither Skeleton Skull"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckylootboxes:lucky_block` | ☐ | ☐ | ☐ |
| Cursed Lucky Block | `/give @p luckylootboxes:cursed_lucky_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Lucky Goblin | `/summon luckylootboxes:lucky_goblin` | ☐ | ☐ | ☐ |
| Cursed Spirit | `/summon luckylootboxes:cursed_spirit` | ☐ | ☐ | ☐ |

### Mob Tests

#### Lucky Goblin

- [ ] Spawns with `/summon luckylootboxes:lucky_goblin`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 3
- [ ] AI behavior works (neutral)
- [ ] Drops loot on death:
  - [ ] minecraft:gold_ingot (100% chance)
  - [ ] minecraft:gold_ingot (100% chance)
  - [ ] minecraft:emerald (100% chance)

#### Cursed Spirit

- [ ] Spawns with `/summon luckylootboxes:cursed_spirit`
- [ ] Has correct health: 30
- [ ] Deals expected damage: 6
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:ghast_tear (100% chance)
  - [ ] luckylootboxes:common_bone (100% chance)
  - [ ] luckylootboxes:rare_wither_skeleton_skull (100% chance)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
